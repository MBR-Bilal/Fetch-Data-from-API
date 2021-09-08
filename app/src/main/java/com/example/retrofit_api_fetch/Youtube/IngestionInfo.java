
package com.example.retrofit_api_fetch.Youtube;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class IngestionInfo {

    @SerializedName("streamName")
    @Expose
    private String streamName;
    @SerializedName("ingestionAddress")
    @Expose
    private String ingestionAddress;
    @SerializedName("backupIngestionAddress")
    @Expose
    private String backupIngestionAddress;
    @SerializedName("rtmpsIngestionAddress")
    @Expose
    private String rtmpsIngestionAddress;
    @SerializedName("rtmpsBackupIngestionAddress")
    @Expose
    private String rtmpsBackupIngestionAddress;

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getIngestionAddress() {
        return ingestionAddress;
    }

    public void setIngestionAddress(String ingestionAddress) {
        this.ingestionAddress = ingestionAddress;
    }

    public String getBackupIngestionAddress() {
        return backupIngestionAddress;
    }

    public void setBackupIngestionAddress(String backupIngestionAddress) {
        this.backupIngestionAddress = backupIngestionAddress;
    }

    public String getRtmpsIngestionAddress() {
        return rtmpsIngestionAddress;
    }

    public void setRtmpsIngestionAddress(String rtmpsIngestionAddress) {
        this.rtmpsIngestionAddress = rtmpsIngestionAddress;
    }

    public String getRtmpsBackupIngestionAddress() {
        return rtmpsBackupIngestionAddress;
    }

    public void setRtmpsBackupIngestionAddress(String rtmpsBackupIngestionAddress) {
        this.rtmpsBackupIngestionAddress = rtmpsBackupIngestionAddress;
    }

}
