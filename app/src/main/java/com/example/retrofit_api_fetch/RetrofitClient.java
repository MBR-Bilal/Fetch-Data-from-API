package com.example.retrofit_api_fetch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Retrofit retrofit;
    private static String BaseURL = "https://clive.christin.website/";

    public static Retrofit getRetrofitInstance() {

        if (retrofit ==null) {

            retrofit = new Retrofit.Builder().baseUrl(BaseURL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;



    }
}
