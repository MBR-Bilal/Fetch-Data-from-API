
package com.example.retrofit_api_fetch.Youtube;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Cdn {

    @SerializedName("ingestionType")
    @Expose
    private String ingestionType;
    @SerializedName("ingestionInfo")
    @Expose
    private IngestionInfo ingestionInfo;
    @SerializedName("resolution")
    @Expose
    private String resolution;
    @SerializedName("frameRate")
    @Expose
    private String frameRate;

    public String getIngestionType() {
        return ingestionType;
    }

    public void setIngestionType(String ingestionType) {
        this.ingestionType = ingestionType;
    }

    public IngestionInfo getIngestionInfo() {
        return ingestionInfo;
    }

    public void setIngestionInfo(IngestionInfo ingestionInfo) {
        this.ingestionInfo = ingestionInfo;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

}
