
package com.example.retrofit_api_fetch.Youtube;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ContentDetails {

    @SerializedName("closedCaptionsIngestionUrl")
    @Expose
    private String closedCaptionsIngestionUrl;
    @SerializedName("isReusable")
    @Expose
    private Boolean isReusable;

    public String getClosedCaptionsIngestionUrl() {
        return closedCaptionsIngestionUrl;
    }

    public void setClosedCaptionsIngestionUrl(String closedCaptionsIngestionUrl) {
        this.closedCaptionsIngestionUrl = closedCaptionsIngestionUrl;
    }

    public Boolean getIsReusable() {
        return isReusable;
    }

    public void setIsReusable(Boolean isReusable) {
        this.isReusable = isReusable;
    }

}
