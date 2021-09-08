package com.example.retrofit_api_fetch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class VerseData {

    @SerializedName("Verse")
    @Expose
    private List<Integer> verse = null;

    public List<Integer> getVerse() {
        return verse;
    }

    public void setVerse(List<Integer> verse) {
        this.verse = verse;
    }

}