package com.example.williamsjonathanandroidcodingchallenge.view.activities.mainactivity;

import android.util.Log;

import com.example.williamsjonathanandroidcodingchallenge.model.datasources.remote.retrofit.RetrofitHelper;
import com.example.williamsjonathanandroidcodingchallenge.model.results.Books;
import com.example.williamsjonathanandroidcodingchallenge.model.results.BooksList;
import com.example.williamsjonathanandroidcodingchallenge.view.adapters.MainActivityRvAdapter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {

    MainActivityContract contract;

    public MainActivityPresenter(MainActivityContract contract){
        this.contract = contract;
    }

    public void getBooks(){
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getObsService()
                .getBooksResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Books>>() {
                    List<Books> books;

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Books> books) {
                        this.books = books;

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG_PRESENTER_MAIN", "ERROR IN API CALL -->", e);

                    }

                    @Override
                    public void onComplete() {
                        setupAdapter(new BooksList(books));


                    }
                });

    }

    public void setupAdapter(BooksList bookList){
        MainActivityRvAdapter mainActivityRvAdapter = new MainActivityRvAdapter(bookList.getBooks());
        contract.onAdapterReady(mainActivityRvAdapter);



    }
}
