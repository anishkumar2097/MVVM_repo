package com.example.booklibrary.remote;

import com.example.booklibrary.pojoclass.BookList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServiceApiInterface {

 String API_KEY="AIzaSyBR6voEK4MuhIVuc0U1QfSiGZpyKgQD0HM";

    /*this is the url
    * https://www.googleapis.com/books/v1/volumes?q=quilting
     **/


  String PARTICULAR_BASE_URL="https://www.googleapis.com/books/v1 ";


         @GET("volumes?q="+"quilting")
       Call<BookList> getBookList();


   //     @GET()
     //  Call<BookList>getBookListByAuthor0rBook();
    }

