package com.example.booklibrary;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklibrary.ViewModel.CustomViewModalFactory;
import com.example.booklibrary.ViewModel.CustomViewModel;
import com.example.booklibrary.pojoclass.BookList;
import com.example.booklibrary.pojoclass.Item;
import com.example.booklibrary.remote.RetrofitServiceClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /**
     * UI <--> Adapter  <--->  ViewModel <--> Retrofit <----> Network
     * UI interact with adapter to get data
     * Data is provided by ViewModel to Adapter if it is already loaded in ViewModel
     * otherwise retrofit make network call to fetch data and is loaded to ViewModel and in turn viewModel
     * provide data to adapter
     */

    List<Book> list;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    //SearchView searchView;
    CustomViewModel viewModel;
    //   RetrofitServiceApiInterface retrofitServiceApiInterface;
    RetrofitServiceClient retrofitServiceClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(adapter);

        retrofitServiceClient = new RetrofitServiceClient();
        viewModel = new ViewModelProvider(this, new CustomViewModalFactory(this.getApplication(), adapter)).get(CustomViewModel.class);
        viewModel.getBooks().observe(this, new Observer<BookList>() {
            @Override
            public void onChanged(BookList bookList) {
                 list=viewModel.uploadListInAdapter(bookList);
                 adapter.updateList(list);
            }
        });
         viewModel.makeApiCall();
    }
}





