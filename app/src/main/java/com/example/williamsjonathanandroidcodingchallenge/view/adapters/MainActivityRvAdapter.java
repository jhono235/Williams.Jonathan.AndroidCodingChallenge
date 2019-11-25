package com.example.williamsjonathanandroidcodingchallenge.view.adapters;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.williamsjonathanandroidcodingchallenge.R;
import com.example.williamsjonathanandroidcodingchallenge.model.results.Books;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivityRvAdapter extends RecyclerView.Adapter<MainActivityRvAdapter.ViewHolder> {
    List<Books> booksList;

    public MainActivityRvAdapter(List<Books> booksList){
        this.booksList = booksList;
    }

    public Books books;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemsfromjson, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        books = booksList.get(position);
        holder.tvBookName.setText(books.getTitle());

       if (books.getAuthor() != null){
           holder.tvBookAuthor.setText("Author: " + books.getAuthor());
       }

        Glide
                .with(holder.itemView)
                .load(books.getImageURL())
                .into(holder.ivBookImage);

    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBookImage;
        TextView tvBookName;
        TextView tvBookAuthor;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivBookImage = itemView.findViewById(R.id.ivBookImage);
            tvBookName = itemView.findViewById(R.id.tvBookName);
            tvBookAuthor = itemView.findViewById(R.id.tvBookAuthor);



        }
    }
}
