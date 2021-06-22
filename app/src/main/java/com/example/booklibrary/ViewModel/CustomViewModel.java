package com.example.booklibrary.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.booklibrary.Book;
import com.example.booklibrary.CustomAdapter;
import com.example.booklibrary.remote.RetrofitServiceClient;
import com.example.booklibrary.pojoclass.BookList;
import com.example.booklibrary.pojoclass.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomViewModel extends ViewModel {

    private CustomAdapter mAdapter;
    private Application mApplication;

    private MutableLiveData<BookList> books;

    CustomViewModel(Application application,CustomAdapter adapter){
        this.mApplication=application;
        this.mAdapter=adapter;

       this.books=new MutableLiveData<>();
    }

    public MutableLiveData<BookList> getBooks() {
         return  books;
    }



    public void makeApiCall() {
        Call<BookList> bookList = RetrofitServiceClient.getClient().getBookList();
        //call instance can be executed either synchronously or asynchronously

        bookList.enqueue(new Callback<BookList>() {

            @Override
            public void onResponse(Call<BookList> call, Response<BookList> response) {
                        books.postValue(response.body());
                       // book=books.getValue();


            }

            @Override
            public void onFailure(Call<BookList> call, Throwable t) {
                books.postValue(null);
                Log.v("MainActivity", "msg:" + call.isExecuted() + t.getMessage());
                t.printStackTrace();
            }
        });


    }

    public List<Book> uploadListInAdapter(BookList Book) {
        //  Log.v("MainActivity", "msg:" + call.isExecuted());
        List<Item> items = Book.getItems();
              items.size();
        List<Book> list=new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            String description = item.getVolumeInfo().getDescription();
            String imageLink = item.getVolumeInfo().getImageLinks().getThumbnail();
            String title = item.getVolumeInfo().getTitle();
            String subTitle = item.getVolumeInfo().getSubtitle();
            List<String> authors = item.getVolumeInfo().getAuthors();

            //   double amount = item.getSaleInfo().getRetailPrice().getAmount();
            //  if(amount)

            Book book = new Book(title, subTitle, description, authors, 100, imageLink);
            list.add(book);
        }
        //mAdapter.updateList(bookList);
        return list;
    }
}
