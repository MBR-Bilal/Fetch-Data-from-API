
package com.example.retrofit_api_fetch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookData {

    @SerializedName("Books")
    @Expose
    private List<String> books = null;

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

}
