package com.example.retrofit_api_fetch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpinnerActivity extends AppCompatActivity {

    AutoCompleteTextView mBookSpinner, mChapterSpinner, mVerseSpinner, mLanguageSpinner;
    private ArrayList<String> getBooksName = new ArrayList<String>();
    ArrayAdapter<String> BooksArrayAdapter;

    TextView mTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        mBookSpinner = findViewById(R.id.Books_Spinner);
        mChapterSpinner = findViewById(R.id.Chapter_Spinner);
        mVerseSpinner = findViewById(R.id.Verse_Spinner);
        mLanguageSpinner = findViewById(R.id.Language_Spinner);
        mTv = findViewById(R.id.Tv);


        // ...... get Books data in spinner .....

        MyAPI_Interface myAPI_interface = RetrofitClient.getRetrofitInstance().create(MyAPI_Interface.class);

        Call<BookData> call = myAPI_interface.getBooksData();
        call.enqueue(new Callback<BookData>() {
            @Override
            public void onResponse(Call<BookData> call, Response<BookData> response) {

                List<String> books = response.body().getBooks();

                ArrayAdapter<String> BooksArrayAdapter = new ArrayAdapter<String>(SpinnerActivity.this, R.layout.option_item, books);
                BooksArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mBookSpinner.setText(BooksArrayAdapter.getItem(0).toString(), false);
                mBookSpinner.setAdapter(BooksArrayAdapter);


                mBookSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                         String booksName= BooksArrayAdapter.getItem(position).toString();

                        // ...... get Chapters data in spinner .....


                        String Json = "{\n" +
                                "    \"name\": \""+booksName+"\"\n" +
                                "}" ;

//                        String Json = "{\n" +
//                                "    \"name\": \"Genesis\"\n" +
//                                "}" ;


                        RequestBody requestBody = RequestBody.create(MediaType.parse("application/Json"), Json);


                        Call<ChaptersData> call_chapters = myAPI_interface.getChaptersData(requestBody);

                        call_chapters.enqueue(new Callback<ChaptersData>() {
                            @Override
                            public void onResponse(Call<ChaptersData> call, Response<ChaptersData> response) {

                                List<Integer> chapters = response.body().getChapters();
                                // mFetched_Data.setText(chapters.toString());

                                ArrayAdapter<Integer> ChaptersArrayAdapter = new ArrayAdapter<Integer>(SpinnerActivity.this, R.layout.option_item, chapters);
                                ChaptersArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                mChapterSpinner.setText(ChaptersArrayAdapter.getItem(0).toString(), false);
                                mChapterSpinner.setAdapter(ChaptersArrayAdapter);




                                mChapterSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                                        String chapterName = ChaptersArrayAdapter.getItem(position).toString();


                                        // ...... get Verse data in spinner .....


                                        String VerseJson = "{\n" +
                                                "    \"name\": \""+booksName+"\",\n" +
                                                "    \"chapter\": "+chapterName+"\n" +
                                                "}" ;



                                        RequestBody requestBody2 = RequestBody.create(MediaType.parse("application/Json"), VerseJson);

                                        Call<VerseData> callVerse = myAPI_interface.getVerseData(requestBody2);

                                        callVerse.enqueue(new Callback<VerseData>() {
                                            @Override
                                            public void onResponse(Call<VerseData> call, Response<VerseData> response) {

                                                List<Integer> verse = response.body().getVerse();
                                                //    mFetched_Data.setText(verse.toString());


                                                ArrayAdapter<Integer> VerseArrayAdapter = new ArrayAdapter<Integer>(SpinnerActivity.this, R.layout.option_item, verse);
                                                VerseArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                mVerseSpinner.setText(VerseArrayAdapter.getItem(0).toString(), false);
                                                mVerseSpinner.setAdapter(VerseArrayAdapter);


                                                mVerseSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                                                        String VerseName = VerseArrayAdapter.getItem(position).toString();


                                                        String ContextJson = "{\n" +
                                                                "    \"name\": \""+booksName+"\",\n" +
                                                                "    \"chapter\": "+chapterName+", \n" +
                                                                "    \"verse\": "+VerseName+"\n" +
                                                                "}" ;



                                                        RequestBody requestBody = RequestBody.create(MediaType.parse("application/Json"), ContextJson);

                                                        Call<ContextData> callContext = myAPI_interface.getContext(requestBody);

                                                        callContext.enqueue(new Callback<ContextData>() {
                                                            @Override
                                                            public void onResponse(Call<ContextData> call, Response<ContextData> response) {


                                                                String [] Languages = {"English", "Hindi", "Kannada", "Malayalam", "Tamil", "Telugu"};

                                                                ArrayAdapter<String> LanguageArrayAdapter = new ArrayAdapter<String>(SpinnerActivity.this, R.layout.option_item, Languages);
                                                                LanguageArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                                mLanguageSpinner.setText(LanguageArrayAdapter.getItem(0).toString(), false);
                                                                mLanguageSpinner.setAdapter(LanguageArrayAdapter);

                                                                mLanguageSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                                    @Override
                                                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                                        switch (position)
                                                                        {
                                                                            case 0:
                                                                                String context_Eng = response.body().getContext().getEnglish();
                                                                                mTv.setText(context_Eng);
                                                                                break;

                                                                            case 1:
                                                                                String context_Hindi = response.body().getContext().getHindi();
                                                                                mTv.setText(context_Hindi);
                                                                                break;

                                                                            case 2:
                                                                                String context_Kannada = response.body().getContext().getKannada();
                                                                                mTv.setText(context_Kannada);
                                                                                break;

                                                                            case 3:
                                                                                String context_Malayalam = response.body().getContext().getMalayalam();
                                                                                mTv.setText(context_Malayalam);
                                                                                break;

                                                                            case 4:
                                                                                String context_Tamil = response.body().getContext().getTamil();
                                                                                mTv.setText(context_Tamil);
                                                                                break;

                                                                            case 5:
                                                                                String context_Telugu = response.body().getContext().getTelugu();
                                                                                mTv.setText(context_Telugu);
                                                                                break;
                                                                        }

                                                                    }
                                                                });



                                                             //   String context = response.body().getContext().getEnglish();
                                                                //   mFetched_Data.setText(context);


                                                            }

                                                            @Override
                                                            public void onFailure(Call<ContextData> call, Throwable t) {

                                                                Toast.makeText(SpinnerActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();

                                                            }
                                                        });

                                                    }
                                                });


                                            }

                                            @Override
                                            public void onFailure(Call<VerseData> call, Throwable t) {

                                                Toast.makeText(SpinnerActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();

                                            }

                                        });




                                    }
                                });



                            }

                            @Override
                            public void onFailure(Call<ChaptersData> call, Throwable t) {

                                Toast.makeText(SpinnerActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        });












                        Toast.makeText(SpinnerActivity.this, booksName, Toast.LENGTH_SHORT).show();

                    }
                });

            }

            @Override
            public void onFailure(Call<BookData> call, Throwable t) {

                Toast.makeText(SpinnerActivity.this, "Error ! " + t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });







        // ...... Select Language in spinner .....


//        String [] Languages = {"English", "Hindi", "Kannada", "Malayalam", "Tamil", "Telugu"};
//
//        ArrayAdapter<String> LanguageArrayAdapter = new ArrayAdapter<String>(SpinnerActivity.this, R.layout.option_item, Languages);
//        LanguageArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mLanguageSpinner.setText(LanguageArrayAdapter.getItem(0).toString(), false);
//        mLanguageSpinner.setAdapter(LanguageArrayAdapter);



















//        String [] BooksName = {" A " , " B " , " C "};
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.option_item, BooksName);
//        mAutoCompleteTv.setText(arrayAdapter.getItem(0).toString(), false);
//        mAutoCompleteTv.setAdapter(arrayAdapter);


    }
}