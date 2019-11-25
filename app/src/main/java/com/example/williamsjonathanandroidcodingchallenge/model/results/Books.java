
package com.example.williamsjonathanandroidcodingchallenge.model.results;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Books {

    @SerializedName("author")
    private String mAuthor;
    @SerializedName("imageURL")
    private String mImageURL;
    @SerializedName("title")
    private String mTitle;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getImageURL() {
        return mImageURL;
    }

    public void setImageURL(String imageURL) {
        mImageURL = imageURL;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
