package com.example.retrofit_api_fetch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpinnerMain extends AppCompatActivity {

    Spinner mBookSpinner, mChapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_main);

        mBookSpinner = findViewById(R.id.Books_Spinner1);
        mChapterSpinner = findViewById(R.id.Chapter_Spinner1);


        // ...... get Books data in spinner .....

        MyAPI_Interface myAPI_interface = RetrofitClient.getRetrofitInstance().create(MyAPI_Interface.class);

        Call<BookData> call = myAPI_interface.getBooksData();
        call.enqueue(new Callback<BookData>() {
            @Override
            public void onResponse(Call<BookData> call, Response<BookData> response) {

                List<String> books = response.body().getBooks();
                //  mFetched_Data.setText(books.toString());

                ArrayAdapter<String> BooksArrayAdapter = new ArrayAdapter<String>(SpinnerMain.this, R.layout.option_item, books);
                BooksArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //  mBookSpinner.setText(BooksArrayAdapter.getItem(0).toString(), false);
                mBookSpinner.setAdapter(BooksArrayAdapter);
            }

            @Override
            public void onFailure(Call<BookData> call, Throwable t) {

                Toast.makeText(SpinnerMain.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



//        String BookSelected = mBookSpinner.getSelectedItem().toString();
//        Toast.makeText(this, BookSelected , Toast.LENGTH_SHORT).show();





        // ...... get Chapters data in spinner .....


        String Json = "{\n" +
                "    \"name\": \"Genesis\"\n" +
                "}" ;

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/Json"), Json);


        Call<ChaptersData> call_chapters = myAPI_interface.getChaptersData(requestBody);

        call_chapters.enqueue(new Callback<ChaptersData>() {
            @Override
            public void onResponse(Call<ChaptersData> call, Response<ChaptersData> response) {

                List<Integer> chapters = response.body().getChapters();
                // mFetched_Data.setText(chapters.toString());

                ArrayAdapter<Integer> ChaptersArrayAdapter = new ArrayAdapter<Integer>(SpinnerMain.this, R.layout.option_item, chapters);
                ChaptersArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             //   mChapterSpinner.setText(ChaptersArrayAdapter.getItem(0).toString(), false);
                mChapterSpinner.setAdapter(ChaptersArrayAdapter);

            }

            @Override
            public void onFailure(Call<ChaptersData> call, Throwable t) {

                Toast.makeText(SpinnerMain.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });





    }
}