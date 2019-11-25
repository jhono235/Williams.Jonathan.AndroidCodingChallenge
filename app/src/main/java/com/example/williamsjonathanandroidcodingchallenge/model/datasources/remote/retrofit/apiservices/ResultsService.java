package com.example.williamsjonathanandroidcodingchallenge.model.datasources.remote.retrofit.apiservices;

import com.example.williamsjonathanandroidcodingchallenge.model.results.Books;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.example.williamsjonathanandroidcodingchallenge.model.datasources.remote.retrofit.UrlConstants.PATH_API;

public interface ResultsService {
    @GET(PATH_API)
    Observable<List<Books>> getBooksResponse();
}
