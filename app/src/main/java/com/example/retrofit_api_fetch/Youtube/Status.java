
package com.example.retrofit_api_fetch.Youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Status {

    @SerializedName("streamStatus")
    @Expose
    private String streamStatus;
    @SerializedName("healthStatus")
    @Expose
    private HealthStatus healthStatus;

    public String getStreamStatus() {
        return streamStatus;
    }

    public void setStreamStatus(String streamStatus) {
        this.streamStatus = streamStatus;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

}
