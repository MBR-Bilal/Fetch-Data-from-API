package com.example.retrofit_api_fetch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ChaptersData {

    @SerializedName("Chapters")
    @Expose
    private List<Integer> chapters = null;

    public List<Integer> getChapters() {
        return chapters;
    }

    public void setChapters(List<Integer> chapters) {
        this.chapters = chapters;
    }

}