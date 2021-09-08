package com.example.retrofit_api_fetch.Youtube;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Yt_RetrofitClient {


    private static Retrofit retrofit;
    private static String BaseURL = "https://youtube.googleapis.com/youtube/v3/";

    public static Retrofit getRetrofitInstance() {

        if (retrofit ==null) {

            retrofit = new Retrofit.Builder().baseUrl(BaseURL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;


    }




}
