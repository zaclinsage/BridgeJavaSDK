package org.sagebionetworks.bridge.sdk.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sagebionetworks.bridge.Tests;
import org.sagebionetworks.bridge.sdk.BridgeServerException;
import org.sagebionetworks.bridge.sdk.ResearcherClient;
import org.sagebionetworks.bridge.sdk.TestUserHelper;
import org.sagebionetworks.bridge.sdk.TestUserHelper.TestUser;
import org.sagebionetworks.bridge.sdk.models.studies.StudyConsent;

public class StudyConsentTest {

    private TestUser researcher;

    @Before
    public void before() {
        researcher = TestUserHelper.createAndSignInUser(StudyConsentTest.class, true, Tests.RESEARCHER_ROLE);
    }

    @After
    public void after() {
        researcher.signOutAndDeleteUser();
    }

    @Test(expected=BridgeServerException.class)
    public void mustBeAdminToAdd() {
        TestUser user = TestUserHelper.createAndSignInUser(StudyConsentTest.class, true);
        try {
            StudyConsent consent = new StudyConsent();
            consent.setPath("/dev/null");
            consent.setMinAge(22);

            user.getSession().getResearcherClient().createStudyConsent(consent);

        } finally {
            user.signOutAndDeleteUser();
        }
    }

    @Test
    public void addAndActiveConsent() {
        ResearcherClient client = researcher.getSession().getResearcherClient();

        StudyConsent consent = new StudyConsent();
        consent.setPath("/dev/null");
        consent.setMinAge(22);
        client.createStudyConsent(consent);

        List<StudyConsent> studyConsents = client.getAllStudyConsents();
        assertNotNull("studyConsents should not be null.", studyConsents);
        assertTrue("studyConsents should have at least one StudyConsent", studyConsents.size() > 0);

        client.getStudyConsent(studyConsents.get(0).getCreatedOn());
    }

}