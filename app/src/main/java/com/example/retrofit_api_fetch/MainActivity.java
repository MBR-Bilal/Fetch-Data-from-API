package com.example.retrofit_api_fetch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit_api_fetch.Youtube.YT_Interface;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    TextView mFetched_Data;
    AutoCompleteTextView mBookSpinner;
    Button mGetBookData_Btn, mGetChapterData_Btn, mGetVerseData_Btn, mGetContext_Button, mGotoSpinner, mGotoSpinnerMain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFetched_Data = findViewById(R.id.Fetched_Data);
        mGetBookData_Btn = findViewById(R.id.getBooksData);
        mGetChapterData_Btn = findViewById(R.id.getChaptersData);
        mGetVerseData_Btn = findViewById(R.id.getVerseData);
        mGetContext_Button = findViewById(R.id.getContext);
        mGotoSpinner = findViewById(R.id.SpinnerActivity);

        mBookSpinner = findViewById(R.id.Books_Spinner);

//        mGotoSpinnerMain = findViewById(R.id.SpinnerActivityMain);



        mGetBookData_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyAPI_Interface myAPI_interface = RetrofitClient.getRetrofitInstance().create(MyAPI_Interface.class);

                Call<BookData> call = myAPI_interface.getBooksData();



                call.enqueue(new Callback<BookData>() {
                    @Override
                    public void onResponse(Call<BookData> call, Response<BookData> response) {


                        List<String> books = response.body().getBooks();
                        mFetched_Data.setText(books.toString());

                        ArrayAdapter<String> BooksArrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.option_item, books);
                        BooksArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        mBookSpinner.setText(BooksArrayAdapter.getItem(0).toString(), false);
                        mBookSpinner.setAdapter(BooksArrayAdapter);
                    }


                    @Override
                    public void onFailure(Call<BookData> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });






        mGetChapterData_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyAPI_Interface myAPI_interface = RetrofitClient.getRetrofitInstance().create(MyAPI_Interface.class);

                String Json = "{\n" +
                        "    \"name\": \"Genesis\"\n" +
                        "}" ;

                RequestBody requestBody = RequestBody.create(MediaType.parse("application/Json"), Json);


                Call<ChaptersData> call = myAPI_interface.getChaptersData(requestBody);

                call.enqueue(new Callback<ChaptersData>() {
                    @Override
                    public void onResponse(Call<ChaptersData> call, Response<ChaptersData> response) {

                        List<Integer> chapters = response.body().getChapters();
                        mFetched_Data.setText(chapters.toString());

                    }

                    @Override
                    public void onFailure(Call<ChaptersData> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });


//                myAPI_interface.getChaptersData(requestBody).enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//
//                        mFetched_Data.setText(response.body().toString());
//
////                        try {
////                            mFetched_Data.setText(response.body().toString());
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();
//
//                    }
//                });


            }
        });











        mGetVerseData_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyAPI_Interface myAPI_interface = RetrofitClient.getRetrofitInstance().create(MyAPI_Interface.class);

                String Json = "{\n" +
                        "    \"name\": \"Genesis\",\n" +
                        "    \"chapter\": 4\n" +
                        "}" ;

                RequestBody requestBody = RequestBody.create(MediaType.parse("application/Json"), Json);

                Call<VerseData> call = myAPI_interface.getVerseData(requestBody);

                call.enqueue(new Callback<VerseData>() {
                    @Override
                    public void onResponse(Call<VerseData> call, Response<VerseData> response) {

                        List<Integer> verse = response.body().getVerse();
                        mFetched_Data.setText(verse.toString());

                    }

                    @Override
                    public void onFailure(Call<VerseData> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });



            }
        });









        mGetContext_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MyAPI_Interface myAPI_interface = RetrofitClient.getRetrofitInstance().create(MyAPI_Interface.class);

                String Json = "{\n" +
                        "    \"name\": \"Genesis\",\n" +
                        "    \"chapter\": 1,\n" +
                        "    \"verse\": 4\n" +
                        "}" ;



                RequestBody requestBody = RequestBody.create(MediaType.parse("application/Json"), Json);

                Call<ContextData> call = myAPI_interface.getContext(requestBody);

                call.enqueue(new Callback<ContextData>() {
                    @Override
                    public void onResponse(Call<ContextData> call, Response<ContextData> response) {

                        String context = response.body().getContext().getEnglish();
                        mFetched_Data.setText(context);


                    }

                    @Override
                    public void onFailure(Call<ContextData> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });


            }
        });







        mGotoSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent GotoSpinner =  new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(GotoSpinner);

            }
        });



//        mGotoSpinnerMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent GotoSpinnerMain =  new Intent(MainActivity.this, SpinnerMain.class);
//                startActivity(GotoSpinnerMain);
//
//            }
//        });



    }
}
