package athrow.rocks.android_project_z.data;

import android.content.ContentValues;

import java.util.Date;

import io.realm.annotations.PrimaryKey;

/**
 * RealmSubmissionRequest
 * Created by jose on 8/27/16.
 */
public class RealmSubmissionRequest {
    @PrimaryKey
    int id;
    int user_id;
    String status;
    Date closed_at;
    Date created_at;
    int submission_id;
    Date updated_at;
    // ContentValues: project_id, language
    ContentValues[] submission_request_projects;

    public RealmSubmissionRequest(int id, int user_id, String status, Date closed_at,
                                  Date created_at, int submission_id, Date updated_at,
                                  ContentValues[] submission_request_projects) {
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.closed_at = closed_at;
        this.created_at = created_at;
        this.submission_id = submission_id;
        this.updated_at = updated_at;
        this.submission_request_projects = submission_request_projects;
    }
}
