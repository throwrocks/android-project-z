package athrow.rocks.android_project_z.data;

/**
 * APIResponse
 * Created by joselopez on 9/21/16.
 */
public final class APIResponse {

    private String responseText;
    private int responseCode;
    private String meta;

    APIResponse() {
    }

    /**
     * setResponseCode
     *
     * @param responseCode the API's response code number
     */
    void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * setResponseText
     *
     * @param responseText the API's response text
     */
    void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    /**
     * getResponseCode
     *
     * @return the API's response code number
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * getResponseText
     *
     * @return the API's response text
     */
    public String getResponseText() {
        return responseText;
    }

    public String getMeta() {
        return meta;
    }

    void setMeta(String meta) {
        this.meta = meta;
    }
}