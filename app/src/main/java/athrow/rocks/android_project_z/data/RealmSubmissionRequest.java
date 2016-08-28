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

    public RealmSubmissionRequest(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getClosed_at() {
        return closed_at;
    }

    public void setClosed_at(Date closed_at) {
        this.closed_at = closed_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(int submission_id) {
        this.submission_id = submission_id;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public ContentValues[] getSubmission_request_projects() {
        return submission_request_projects;
    }

    public void setSubmission_request_projects(ContentValues[] submission_request_projects) {
        this.submission_request_projects = submission_request_projects;
    }
}
