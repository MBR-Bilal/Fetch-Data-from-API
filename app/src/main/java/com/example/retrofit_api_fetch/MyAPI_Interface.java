package com.example.retrofit_api_fetch;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.jar.Attributes;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyAPI_Interface {

    @GET("books")
    Call<BookData> getBooksData();


//    @POST("getChapters")
//    Call<ResponseBody> getChaptersData(@Body RequestBody requestBody);


    @POST("getChapters")
    Call<ChaptersData> getChaptersData(@Body RequestBody requestBody);


    @POST("getVerse")
    Call<VerseData> getVerseData(@Body RequestBody requestBody);


    @POST("context")
    Call<ContextData> getContext(@Body RequestBody requestBody);


//    @GET("getChapters/{Book_name}")
//    Call<ChaptersData> getChaptersData(@Path("Book_name") String Book_name);


//    @FormUrlEncoded
//    @POST("getChapters")
//    Call<ChaptersData> getChaptersData(@Body Attributes.Name)
//
//
//
//    @POST("name")
//    Call<ResponseBody> getChaptersData(@Field("chapter_number") String chapter_number);


}
