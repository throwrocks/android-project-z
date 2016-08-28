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

    public RealmCertification(int id, String status, int project_id, int grader_id,
                               Date created_at, Date updated_at, Date waitlisted_at,
                               Date certified_at, int trainings_count, Boolean active,
                               String notes, String project_languages_to_recruit,
                               String project_name, double project_price, int project_udacity_key,
                               Date project_created_at, Date project_updated_at,
                               String project_description, String project_required_skills,
                               Boolean private_visible, int project_awaiting_review_count,
                               Boolean project_waitlist, String project_nanodegree_key,
                               int project_audit_project_id, Boolean project_nomination_eligible,
                               String project_hashtag) {
        this.id = id;
        this.status = status;
        this.project_id = project_id;
        this.grader_id = grader_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.waitlisted_at = waitlisted_at;
        this.certified_at = certified_at;
        this.trainings_count = trainings_count;
        this.active = active;
        this.notes = notes;
        this.project_languages_to_recruit = project_languages_to_recruit;
        this.project_name = project_name;
        this.project_price = project_price;
        this.project_udacity_key = project_udacity_key;
        this.project_created_at = project_created_at;
        this.project_updated_at = project_updated_at;
        this.project_description = project_description;
        this.project_required_skills = project_required_skills;
        this.private_visible = private_visible;
        this.project_awaiting_review_count = project_awaiting_review_count;
        this.project_waitlist = project_waitlist;
        this.project_nanodegree_key = project_nanodegree_key;
        this.project_audit_project_id = project_audit_project_id;
        this.project_nomination_eligible = project_nomination_eligible;
        this.project_hashtag = project_hashtag;
    }
}