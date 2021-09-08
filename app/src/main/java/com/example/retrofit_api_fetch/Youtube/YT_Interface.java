package com.example.retrofit_api_fetch.Youtube;

import com.example.retrofit_api_fetch.ChaptersData;

import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface YT_Interface {



//    String YOUR_API_KEY = "AIzaSyD5XSG5t79JSgkne78PSWTbgE5CM76fCHo";


    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
    Call<Cdn> getCdn(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving kind



//    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
//    Call<YtStreamData> getKind(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving kind
//
//    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
//    Call<YtStreamData> getEtag(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving Etag
//
//    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
//    Call<YtStreamData> getId(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving id
//
//    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
//    Call<YtStreamData> getSnippet(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving snippet
//
//    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
//    Call<YtStreamData> getCdn(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving cdn
//
//    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
//    Call<YtStreamData> getStatus(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving status
//
//    @POST("liveStreams?part=snippet%2Ccdn%2CcontentDetails%2Cstatus&key=[YOUR_API_KEY]")
//    Call<YtStreamData> getContentDetails(@HeaderMap Map<String, String> headers, @Body RequestBody requestBody); //For receiving contentDetails


//     key=[AIzaSyD5XSG5t79JSgkne78PSWTbgE5CM76fCHo]")


//    @POST("liveStreams?part=snippet&key=[AIzaSyD5XSG5t79JSgkne78PSWTbgE5CM76fCHo]")
//    Call<Snippet> mySnippet(@Body RequestBody requestBody);
//
//
//    @POST("liveStreams?part=cdn&key=[AIzaSyD5XSG5t79JSgkne78PSWTbgE5CM76fCHo]")
//    Call<Cdn> myCdn(@Body RequestBody requestBody);
//
//
//    @POST("liveStreams?part=contentDetails&key=[AIzaSyD5XSG5t79JSgkne78PSWTbgE5CM76fCHo]")
//    Call<ContentDetails> myContentDetails(@Body RequestBody requestBody);
//
//
//    @POST("liveStreams?part=status&key=[AIzaSyD5XSG5t79JSgkne78PSWTbgE5CM76fCHo]")
//    Call<Status> myStatus(@Body RequestBody requestBody);

}
