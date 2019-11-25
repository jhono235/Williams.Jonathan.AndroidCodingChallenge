
package com.example.williamsjonathanandroidcodingchallenge.model.results;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BooksList implements Serializable {
    @SerializedName("books")
    @Expose
    private List<Books> books  = null;

    public BooksList(List<Books> books){
        this.books = books;
    }

    public List<Books> getBooks(){
        return books;
    }


}
