
package com.example.retrofit_api_fetch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ContextData {

    @SerializedName("context")
    @Expose
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}

