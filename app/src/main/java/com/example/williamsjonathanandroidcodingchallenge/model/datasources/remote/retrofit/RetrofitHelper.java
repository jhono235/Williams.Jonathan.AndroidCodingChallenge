package com.example.williamsjonathanandroidcodingchallenge.model.datasources.remote.retrofit;

import com.example.williamsjonathanandroidcodingchallenge.model.datasources.remote.retrofit.apiservices.ResultsService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.williamsjonathanandroidcodingchallenge.model.datasources.remote.retrofit.UrlConstants.BASE_URL;

public class RetrofitHelper {

    private Retrofit getRetrofitFinstance(){
        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ResultsService getObsService(){
        return getRetrofitFinstance()
                .create(ResultsService.class);
    }
}
