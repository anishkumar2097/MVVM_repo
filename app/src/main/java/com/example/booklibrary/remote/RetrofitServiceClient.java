package com.example.booklibrary.remote;

import android.util.Log;

import com.example.booklibrary.remote.RetrofitServiceApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceClient {


    private static final String TAG = "RetrofitServiceClient";
 //   private static String BASE_URL = "https://api.themoviedb.org/3/";

    private static final  String PARTICULAR_BASE_URL="https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes/";
    private static Retrofit retrofit = null;

    public static RetrofitServiceApiInterface getClient() {

        // change your base URL
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder()
                       // .baseUrl(PARTICULAR_BASE_URL)
                        .baseUrl("https://www.googleapis.com/books/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (Exception ex) {
                Log.e(TAG, "getClient:");
            }
        }
        //Creating object for our interface
        RetrofitServiceApiInterface api = retrofit.create(RetrofitServiceApiInterface.class);
        return api; // return the APIInterface object
    }
}
