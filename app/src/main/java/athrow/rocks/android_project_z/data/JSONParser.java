package athrow.rocks.android_project_z.data;

import android.content.ContentValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * JSONParser
 * Created by jose on 8/28/16.
 */
public class JSONParser {
    private JSONParser() {
        throw new AssertionError("No JSONParser instances for you!");
    }

    public static ContentValues[] parseCertifications(String reviewsJSON) {
        ContentValues[] contentValues = null;
        if (reviewsJSON != null) {
            try {
                JSONArray certificationsArray = new JSONArray(reviewsJSON);
                int certificationsQty = certificationsArray.length();
                contentValues = new ContentValues[certificationsQty];
                for (int i = 0; i < certificationsQty; i++) {
                    JSONObject certificationRecord = certificationsArray.getJSONObject(i);
                    ContentValues certificationValues = new ContentValues();
                    int id = certificationRecord.getInt("id");
                    String status = certificationRecord.getString("status");
                    int project_id = certificationRecord.getInt("project_id");
                    int grader_id = certificationRecord.getInt("grader_id");
                    int trainings_count = certificationRecord.getInt("trainings_count");
                    // Get date strings and convert them to date objects
                    String created_at = certificationRecord.getString("created_at");
                    String updated_at = certificationRecord.getString("updated_at");
                    String waitlisted_at = certificationRecord.getString("waitlisted_at");
                    String certified_at = certificationRecord.getString("certified_at");
                    Boolean active = certificationRecord.getBoolean("active");
                    String notes = certificationRecord.getString("notes");
                    certificationValues.put("id", id);
                    certificationValues.put("status", status);
                    certificationValues.put("project_id", project_id);
                    certificationValues.put("grader_id", grader_id);
                    certificationValues.put("trainings_count", trainings_count);
                    certificationValues.put("created_at", created_at);
                    certificationValues.put("updated_at", updated_at);
                    certificationValues.put("waitlisted_at", waitlisted_at);
                    certificationValues.put("certified_at", certified_at);
                    certificationValues.put("active", active);
                    certificationValues.put("notes", notes);
                    //----------------------------------------------------------------------------------
                    // Project Node
                    //----------------------------------------------------------------------------------
                    JSONObject projectNode = certificationRecord.getJSONObject("project");
                    String project_name = projectNode.getString("name");
                    double project_price = projectNode.getDouble("price");
                    int project_udacity_key = projectNode.getInt("udacity_key");
                    String project_created_at = projectNode.getString("created_at");
                    String project_updated_at = projectNode.getString("updated_at");
                    String project_description = projectNode.getString("description");
                    String project_required_skills = projectNode.getString("required_skills");
                    Boolean project_visible = projectNode.getBoolean("visible");
                    int project_awaiting_review_count = projectNode.getInt("awaiting_review_count");
                    Boolean project_wailist = projectNode.getBoolean("waitlist");
                    String project_nanodegree_key = projectNode.getString("nanodegree_key");
                    int project_audit_project_id = projectNode.getInt("audit_project_id");
                    Boolean project_nomination_eligible = projectNode.getBoolean("nomination_eligible");
                    String project_hashtag = projectNode.getString("hashtag");
                    certificationValues.put("project_name", project_name);
                    certificationValues.put("project_price", project_price);
                    certificationValues.put("project_udacity_key", project_udacity_key);
                    certificationValues.put("project_created_at", project_created_at);
                    certificationValues.put("project_updated_at", project_updated_at);
                    certificationValues.put("project_description", project_description);
                    certificationValues.put("project_required_skills", project_required_skills);
                    certificationValues.put("project_visible", project_visible);
                    certificationValues.put("project_awaiting_review_count", project_awaiting_review_count);
                    certificationValues.put("project_wailist", project_wailist);
                    certificationValues.put("project_nanodegree_key", project_nanodegree_key);
                    certificationValues.put("project_audit_project_id", project_audit_project_id);
                    certificationValues.put("project_nomination_eligible", project_nomination_eligible);
                    certificationValues.put("project_hashtag", project_hashtag);
                    //----------------------------------------------------------------------------------
                    // Add the ContentValues to the Array
                    //----------------------------------------------------------------------------------
                    contentValues[i] = certificationValues;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return contentValues;
    }

}
