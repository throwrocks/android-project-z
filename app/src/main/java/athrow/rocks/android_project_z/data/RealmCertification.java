package athrow.rocks.android_project_z.data;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * RealmCertifications
 * Created by jose on 8/27/16.
 */
public class RealmCertification extends RealmObject {
    @PrimaryKey
    int id;
    String status;
    int project_id;
    int grader_id;
    Date created_at;
    Date updated_at;
    Date waitlisted_at;
    Date certified_at;
    int trainings_count;
    Boolean active;
    String notes;
    String project_languages_to_recruit;
    String project_name;
    double project_price;
    int project_udacity_key;
    Date project_created_at;
    Date project_updated_at;
    String project_description;
    String project_required_skills;
    Boolean private_visible;
    int project_awaiting_review_count;
    Boolean project_waitlist;
    String project_nanodegree_key;
    int project_audit_project_id;
    Boolean project_nomination_eligible;
    String project_hashtag;

    public RealmCertification(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getGrader_id() {
        return grader_id;
    }

    public void setGrader_id(int grader_id) {
        this.grader_id = grader_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getWaitlisted_at() {
        return waitlisted_at;
    }

    public void setWaitlisted_at(Date waitlisted_at) {
        this.waitlisted_at = waitlisted_at;
    }

    public Date getCertified_at() {
        return certified_at;
    }

    public void setCertified_at(Date certified_at) {
        this.certified_at = certified_at;
    }

    public int getTrainings_count() {
        return trainings_count;
    }

    public void setTrainings_count(int trainings_count) {
        this.trainings_count = trainings_count;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProject_languages_to_recruit() {
        return project_languages_to_recruit;
    }

    public void setProject_languages_to_recruit(String project_languages_to_recruit) {
        this.project_languages_to_recruit = project_languages_to_recruit;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public double getProject_price() {
        return project_price;
    }

    public void setProject_price(double project_price) {
        this.project_price = project_price;
    }

    public int getProject_udacity_key() {
        return project_udacity_key;
    }

    public void setProject_udacity_key(int project_udacity_key) {
        this.project_udacity_key = project_udacity_key;
    }

    public Date getProject_created_at() {
        return project_created_at;
    }

    public void setProject_created_at(Date project_created_at) {
        this.project_created_at = project_created_at;
    }

    public Date getProject_updated_at() {
        return project_updated_at;
    }

    public void setProject_updated_at(Date project_updated_at) {
        this.project_updated_at = project_updated_at;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getProject_required_skills() {
        return project_required_skills;
    }

    public void setProject_required_skills(String project_required_skills) {
        this.project_required_skills = project_required_skills;
    }

    public Boolean getPrivate_visible() {
        return private_visible;
    }

    public void setPrivate_visible(Boolean private_visible) {
        this.private_visible = private_visible;
    }

    public int getProject_awaiting_review_count() {
        return project_awaiting_review_count;
    }

    public void setProject_awaiting_review_count(int project_awaiting_review_count) {
        this.project_awaiting_review_count = project_awaiting_review_count;
    }

    public Boolean getProject_waitlist() {
        return project_waitlist;
    }

    public void setProject_waitlist(Boolean project_waitlist) {
        this.project_waitlist = project_waitlist;
    }

    public String getProject_nanodegree_key() {
        return project_nanodegree_key;
    }

    public void setProject_nanodegree_key(String project_nanodegree_key) {
        this.project_nanodegree_key = project_nanodegree_key;
    }

    public int getProject_audit_project_id() {
        return project_audit_project_id;
    }

    public void setProject_audit_project_id(int project_audit_project_id) {
        this.project_audit_project_id = project_audit_project_id;
    }

    public Boolean getProject_nomination_eligible() {
        return project_nomination_eligible;
    }

    public void setProject_nomination_eligible(Boolean project_nomination_eligible) {
        this.project_nomination_eligible = project_nomination_eligible;
    }

    public String getProject_hashtag() {
        return project_hashtag;
    }

    public void setProject_hashtag(String project_hashtag) {
        this.project_hashtag = project_hashtag;
    }

}