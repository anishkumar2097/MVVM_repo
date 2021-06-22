package com.example.booklibrary.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.booklibrary.CustomAdapter;
import com.example.booklibrary.remote.RetrofitServiceClient;
import com.example.booklibrary.pojoclass.BookList;

import retrofit2.Response;

public class CustomViewModalFactory implements ViewModelProvider.Factory {
       private MutableLiveData<Response<BookList>> response;
       private CustomAdapter mAdapter;
       private Application mApplication;

      public CustomViewModalFactory(Application application, CustomAdapter adapter){
                   this.mApplication=application;
                   this.mAdapter=adapter;

       }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        CustomViewModel model  =new CustomViewModel(mApplication,mAdapter);
        return (T) model;
    }
}
