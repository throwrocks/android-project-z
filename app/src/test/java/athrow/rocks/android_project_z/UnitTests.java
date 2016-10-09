package athrow.rocks.android_project_z;

import android.content.ContentValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import athrow.rocks.android_project_z.data.API;
import athrow.rocks.android_project_z.data.APIResponse;
import athrow.rocks.android_project_z.data.JSONParser;
import athrow.rocks.android_project_z.data.ProjectRequest;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class UnitTests extends Robolectric {
    String mBuildAPIKey = BuildConfig.UDACITY_REVIEWER_API_KEY;
    APIResponse apiResponse;
    String mCertificationsJSON;

    @Before
    public void setUp() throws Exception {
        if (mCertificationsJSON == null) {
            mCertificationsJSON = API.getCertifications(mBuildAPIKey).getResponseText();
        }

    }

    @Test
    public void testGetCertifications() throws Exception {
        assertTrue(mCertificationsJSON != null);
    }

    @Test
    public void testParsingCertifications() {
        ContentValues[] parsedResults = JSONParser.parseCertifications(mCertificationsJSON);
        assertTrue(parsedResults != null);
        assertTrue(parsedResults[0].size() == 25);
    }


    @Test
    public void testSubmissionRequest() throws Exception{
        // Check if there's an open request
        //String request  = API.getSubmissionRequest(mBuildAPIKey);
        //JSONArray requestArray = new JSONArray(request);
        // If there isn't create a new request
        //if ( requestArray.length() == 0){
            String requestString = "{\"projects\": [{\"project_id\": 159,\"language\": \"en-us\"}]}";
            String x = API.createSubmissionRequest(mBuildAPIKey, requestString).getResponseText();
            API.getSubmissionRequest(mBuildAPIKey);
        //}
        // Get the project id from the new request
        //JSONArray jsonArray = new JSONArray(request);
        //try{
            //JSONObject object = jsonArray.getJSONObject(0);
            //int id = object.getInt("id");
            // Delete the request
            //String deleteResults = API.deleteSubmissionRequest(mBuildAPIKey, id);
        //}
        //catch (JSONException jsonException){
           // jsonException.printStackTrace();
        //}
    }

    @Test
    public void testBuildProjectRequest() throws Exception{
        //ProjectRequest request = new ProjectRequest(100, "en-us");
        String requestString = "'projects': [{'project_id': 159, 'language': 'en'}]";
        //request.toString();
        try {
            JSONObject requestObject = new JSONObject(requestString);
            int requestProjectId = requestObject.getInt("project_id");
            String requestLanguage = requestObject.getString("language");
            assertTrue(requestProjectId == 100 && requestLanguage.equals("en-us"));
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
            assertTrue(false);
        }
    }

}