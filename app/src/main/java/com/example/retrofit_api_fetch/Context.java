
package com.example.retrofit_api_fetch;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Context {

    @SerializedName("ENGLISH")
    @Expose
    private String english;
    @SerializedName("HINDI")
    @Expose
    private String hindi;
    @SerializedName("KANNADA")
    @Expose
    private String kannada;
    @SerializedName("MALAYALAM")
    @Expose
    private String malayalam;
    @SerializedName("TAMIL")
    @Expose
    private String tamil;
    @SerializedName("TELUGU")
    @Expose
    private String telugu;

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public String getKannada() {
        return kannada;
    }

    public void setKannada(String kannada) {
        this.kannada = kannada;
    }

    public String getMalayalam() {
        return malayalam;
    }

    public void setMalayalam(String malayalam) {
        this.malayalam = malayalam;
    }

    public String getTamil() {
        return tamil;
    }

    public void setTamil(String tamil) {
        this.tamil = tamil;
    }

    public String getTelugu() {
        return telugu;
    }

    public void setTelugu(String telugu) {
        this.telugu = telugu;
    }

}
