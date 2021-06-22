package com.example.booklibrary;

import android.content.Context;
import android.text.style.AlignmentSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.holder> {

    Context context;
    List<Book> bookList;



    public CustomAdapter(Context context, List<Book> bookList) {
        this.context=context;
        this.bookList=bookList;

    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
      return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
            Book book= bookList.get(position);
            String title=book.geBookTitle();
         holder.description.setText(book.getDescription());
         holder.title.setText(book.geBookTitle());
        Glide.with(context).load(book.imageLinks).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public void updateList(List<Book> list){
        bookList = list;
        notifyDataSetChanged();
    }

    public class holder extends RecyclerView.ViewHolder{


        TextView title;
        ImageView imageView;
        TextView description;
        public holder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title_view);
            imageView=itemView.findViewById(R.id.image_view);
            description=itemView.findViewById(R.id.description);



        }
    }

}

