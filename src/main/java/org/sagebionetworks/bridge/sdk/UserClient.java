package org.sagebionetworks.bridge.sdk;

import java.util.List;

import org.joda.time.DateTime;
import org.sagebionetworks.bridge.sdk.models.ResourceList;
import org.sagebionetworks.bridge.sdk.models.UploadRequest;
import org.sagebionetworks.bridge.sdk.models.UploadSession;
import org.sagebionetworks.bridge.sdk.models.holders.GuidCreatedOnVersionHolder;
import org.sagebionetworks.bridge.sdk.models.holders.IdentifierHolder;
import org.sagebionetworks.bridge.sdk.models.schedules.Schedule;
import org.sagebionetworks.bridge.sdk.models.schedules.Task;
import org.sagebionetworks.bridge.sdk.models.surveys.Survey;
import org.sagebionetworks.bridge.sdk.models.surveys.SurveyAnswer;
import org.sagebionetworks.bridge.sdk.models.surveys.SurveyResponse;
import org.sagebionetworks.bridge.sdk.models.upload.UploadValidationStatus;
import org.sagebionetworks.bridge.sdk.models.users.ConsentSignature;
import org.sagebionetworks.bridge.sdk.models.users.ExternalIdentifier;
import org.sagebionetworks.bridge.sdk.models.users.SharingScope;
import org.sagebionetworks.bridge.sdk.models.users.UserProfile;

public interface UserClient {

    /**
     * Retrieve the UserProfile associated with the currently signed in account.
     *
     * @return UserProfile
     */
    public UserProfile getProfile();

    /**
     * Update the UserProfile associated with the currently signed in account.
     *
     * @param profile
     *      changed profile object that will be used to update UserProfile info on Bridge.
     */
    public void saveProfile(UserProfile profile);
    
    /**
     * Add an external participant identifier for the current user. This identifier may be provided by some studies in
     * order to collate research data collected through Bridge with external sources of information about the
     * participant. Bridge does not verify the uniqueness of this identifier. The identifier may be updated, but it
     * cannot be removed (if necessary, set it to a deleted value like "N/A").
     * 
     * @param identifier
     *      a unique identifier for this participant in this study, generated by an external authority
     */
    public void addExternalUserIdentifier(ExternalIdentifier identifier);

    /**
     * Consent to research.
     *
     * @param signature
     *          Name, birthdate, and optionally signature image, of consenter's signature.
     * @param scope
     *          Scope of sharing for this consent
     */
    public void consentToResearch(ConsentSignature signature, SharingScope scope);

    /**
     * Returns the user's consent signature, which includes the name, birthdate, and signature image.
     *
     * @return consent signature
     */
    public ConsentSignature getConsentSignature();

    /**
     * Change (stop, resume) the sharing of data for this participant.
     * @param sharing
     */
    public void changeSharingScope(SharingScope sharing);
    
    /**
     * Get all schedules associated with a study.
     *
     * @return List<Schedule>
     */
    public ResourceList<Schedule> getSchedules();

    /**
     * Get a survey version with a GUID and a createdOn timestamp.
     *
     * @param keys
     *
     * @return Survey
     */
    public Survey getSurvey(GuidCreatedOnVersionHolder keys);
    
    /**
     * Submit a list of SurveyAnswers to a particular survey.
     *
     * @param keys
     *            The survey that the answers will be added to.
     * @param answers
     *            The answers to add to the survey.
     * @return GuidHolder A holder storing the GUID of the survey.
     */
    public IdentifierHolder submitAnswersToSurvey(GuidCreatedOnVersionHolder keys, List<SurveyAnswer> answers);

    /**
     * Submit a list of SurveyAnswers to a particular survey, using a specified identifier
     * for the survey response (the value should be a unique string, like a GUID, that 
     * has not been used for any prior submissions).
     *
     * @param survey
     *            The survey that the answers will be added to.
     * @param identifier
     *            A unique string to identify this set of survey answers as originating
     *            from the same run of a survey
     * @param answers
     *            The answers to add to the survey.
     * @return IdentifierHolder A holder storing the GUID of the survey.
     */
    public IdentifierHolder submitAnswersToSurvey(Survey survey, String identifier, List<SurveyAnswer> answers);
    
    /**
     * Get the survey response associated with the guid string paramater.
     *
     * @param surveyResponseGuid
     *            The GUID identifying the SurveyResponse
     * @return SurveyResponse
     */
    public SurveyResponse getSurveyResponse(String surveyResponseGuid);

    /**
     * Add a list of SurveyAnswers to a SurveyResponse.
     *
     * @param response
     *            The response that answers will be added to.
     * @param answers
     *            The answers that will be added to the response.
     */
    public void addAnswersToResponse(SurveyResponse response, List<SurveyAnswer> answers);

    /**
     * Request an upload session from the user.
     *
     * @param request
     *            the request object Bridge uses to create the Upload Session.
     * @return UploadSession
     */
    public UploadSession requestUploadSession(UploadRequest request);

    /**
     * Upload a file using the requested UploadSession. Closes the upload after it's done.
     *
     * @param session
     *            The session used to upload.
     * @param fileName
     *            File to upload.
     */
    public void upload(UploadSession session, UploadRequest request, String fileName);

    /**
     * Gets the upload status (status and validation messages) for the given upload ID
     *
     * @param uploadId
     *         ID of the upload, obtained from the upload session
     * @return object containing upload status and validation messages
     */
    public UploadValidationStatus getUploadStatus(String uploadId);
    
    /**
     * Get the list of available or scheduled tasks.
     * @param until
     *      return tasks from now until the date and time of the until parameter (if null, 
     *      the server's default will be used, currently 4 days).
     * @return
     */
    public ResourceList<Task> getTasks(DateTime until);
    
    /**
     * Update these tasks (by setting either the startedOn or finishedOn values of the task). 
     * The only other required value that must be set for the task is its GUID.
     * @param tasks
     */
    public void updateTasks(List<Task> tasks);
}
