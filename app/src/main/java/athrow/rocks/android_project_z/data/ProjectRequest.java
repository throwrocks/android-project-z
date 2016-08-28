package athrow.rocks.android_project_z.data;

/**
 * ProjectRequest
 * A class to build the requested projects
 * To be passed to the API using toString as the request body
 * Created by jose on 8/28/16.
 */
public class ProjectRequest {
    int projectId;
    String language;

    public ProjectRequest(int projectId, String language) {
        this.projectId = projectId;
        this.language = language;
    }

    @Override
    public String toString() {
        return "{" +
                "\"project_id\":" + projectId + ", " +
                "\"language\":" + "\"" + language + "\"" +
                '}';
    }
}
