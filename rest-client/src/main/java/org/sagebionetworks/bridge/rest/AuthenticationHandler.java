package org.sagebionetworks.bridge.rest;

import java.io.IOException;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sagebionetworks.bridge.rest.model.SignIn;
import org.sagebionetworks.bridge.rest.model.UserSessionInfo;

import com.google.common.base.Preconditions;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.Route;

/**
 * Authenticates a user with Bridge: retrieves session and attaches token to header.
 */
class AuthenticationHandler implements Authenticator, Interceptor {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationHandler.class);
    private static final int MAX_TRIES = 3;

    private final SignIn signIn;
    private final UserSessionInfoProvider userSessionInfoProvider;

    private UserSessionInfo userSession;
    private int tryCount;

    /**
     * @param signIn
     *         credentials for the user
     * @param userSessionInfoProvider
     *         for retrieving the user's session
     */
    public AuthenticationHandler(SignIn signIn, UserSessionInfoProvider userSessionInfoProvider) {
        Preconditions.checkNotNull(signIn);
        Preconditions.checkNotNull(userSessionInfoProvider);
        this.signIn = signIn;
        this.userSessionInfoProvider = userSessionInfoProvider;
    }


    @Override
    public okhttp3.Request authenticate(Route route, okhttp3.Response response) throws IOException {
        // if we reach this part of the code, the server had returned a 401 and userSession is
        // invalid
        userSessionInfoProvider.purgeCachedSession(this.userSession);
        this.userSession = null;

        if (tryCount >= MAX_TRIES || !isValidSignIn(signIn)) {
            LOG.info("Maximum retries reached");
            this.tryCount = 0;

            // returning null terminates the request chain and propagates the 401
            return null;
        }
        tryCount++;

        userSession = userSessionInfoProvider.retrieveSession(signIn);

        // interceptor was already triggered for this request and failed to authenticate
        // add headers again, now that we've retrieved a session again
        return addBridgeHeaders(response.request());
    }

    private boolean isValidSignIn(SignIn signIn) {
        return signIn != null && !Strings.isNullOrEmpty(signIn.getEmail()) && !Strings
                .isNullOrEmpty(signIn.getPassword());
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response response = chain.proceed(addBridgeHeaders(chain.request()));

        // if we reach this part of the code, we didn't get a 401 and the authenticator did its job
        this.tryCount = 0;

        return response;
    }

    private okhttp3.Request addBridgeHeaders(okhttp3.Request request) throws IOException {
        String sessionToken = getSessionToken();

        if (sessionToken == null) {
            return request;
        }
        return request.newBuilder().header("Bridge-Session", sessionToken).build();
    }

    // allow tests to inspect current session token
    String getSessionToken() {
        return this.userSession == null ? null : this.userSession.getSessionToken();
    }
}