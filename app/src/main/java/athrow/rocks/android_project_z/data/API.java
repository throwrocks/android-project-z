package athrow.rocks.android_project_z.data;

/**
 * Created by jose on 8/27/16.
 */

import android.content.ContentValues;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import athrow.rocks.android_project_z.util.Utilities;

/***
 * API
 * This class manages the connection to the Udacity API
 * Created by joselopez on 3/10/16.
 */
public final class API {

    private API() {
        throw new AssertionError("No API instances for you!");
    }


    public static String callCertificationsAPI(String APIKey){
        String APIUrl = "https://review-api.udacity.com/api/v1/me/certifications";
        return httpConnect(APIKey, APIUrl);
    }

    /**
     * httpConnect
     * This method handles communicating with the API and converting the input stream into a string
     *
     * @return a json string to be used in a parsing method
     */
    private static String httpConnect(String APIKey, String APIurl) {
        String results = null;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            // Build the URL
            Uri builtUri = Uri.parse(APIurl).buildUpon().build();
            URL url = new URL(builtUri.toString());
            // Establish the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.addRequestProperty("Authorization", APIKey);
            urlConnection.addRequestProperty("Content-Length", "0");
            urlConnection.addRequestProperty("Accept", "application/json");
            urlConnection.connect();
            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            if (buffer.length() == 0) {
                results = null;
            }
            results = buffer.toString();
        } catch (IOException v) {
            results = null;
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
        return results;
    }
}