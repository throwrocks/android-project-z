package athrow.rocks.android_project_z.data;

/**
 * Created by jose on 8/27/16.
 */

import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/***
 * API
 * This class manages the connection to the Udacity API
 * Created by joselopez on 3/10/16.
 */
public final class API {

    private API() {
        throw new AssertionError("No API instances for you!");
    }

    /**
     * getCertifications
     * Get all the authenticated reviewer's certifications
     * @param APIKey the API key
     * @return a string of JSON formatted results
     */
    public static APIResponse getCertifications(String APIKey){
        String APIUrl = "https://review-api.udacity.com/api/v1/me/certifications";
        return httpConnect(APIKey, APIUrl, "GET", "");
    }

    /**
     * getSubmissionRequest
     * Get all the authenticated reviewer's certifications
     * @param APIKey the API key
     * @return a string of JSON formatted results
     */
    public static APIResponse getSubmissionRequest(String APIKey){
        String APIUrl = "https://review-api.udacity.com/api/v1/me/submission_requests";
        return httpConnect(APIKey, APIUrl, "GET", "");
    }

    /**
     * createSubmissionRequest
     * @param APIKey APIKey the API key
     * @param requestedProjects a JSON string of requested projects
     * @return a string of JSON formatted results
     */
    public static APIResponse createSubmissionRequest(String APIKey, String requestedProjects){
        String APIUrl = "https://review-api.udacity.com/api/v1/submission_requests";
        return httpConnect(APIKey, APIUrl, "POST", requestedProjects);
    }

    /**
     * deleteSubmissionRequest
     * @param APIKey APIKey the API key
     * @param requestId the id of the submission request to delete
     * @return a string of JSON formatted results
     */
    public static APIResponse deleteSubmissionRequest(String APIKey, int requestId){
        String APIUrl = "https://review-api.udacity.com/api/v1/submission_requests/" + requestId;
        return httpConnect(APIKey, APIUrl, "DELETE", "");
    }

    /**
     * httpConnect
     * This method handles communicating with the API and converting the input stream into a string
     * @param apiKey the API key
     * @param apiUrl the request url
     * @param requestMethod the request's method (GET, PUT, DELETE)
     * @param requestBody the request's body (optional)
     * @return a json string to be used in a parsing method
     */
    private static APIResponse httpConnect(String apiKey, String apiUrl, String requestMethod, String requestBody) {
        APIResponse apiResponse = new APIResponse();
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            // Build the URL
            Uri builtUri = Uri.parse(apiUrl).buildUpon().build();
            URL url = new URL(builtUri.toString());
            // Establish the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(requestMethod);
            urlConnection.addRequestProperty("Authorization", apiKey);
            //urlConnection.addRequestProperty("Content-Length", "0");
            urlConnection.addRequestProperty("Body", requestBody);
            urlConnection.addRequestProperty("Content-Type", "application/json");
            urlConnection.addRequestProperty("Accept", "application/json");
            urlConnection.connect();
            apiResponse.setResponseCode(urlConnection.getResponseCode());
            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();
            if (inputStream == null) {
                return apiResponse;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            if (buffer.length() == 0) {
                return apiResponse;
            }
            apiResponse.setResponseText(buffer.toString());
        } catch (IOException v) {
            apiResponse.setResponseText( "error: IOException " + v);
            return apiResponse;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return apiResponse;
    }
}