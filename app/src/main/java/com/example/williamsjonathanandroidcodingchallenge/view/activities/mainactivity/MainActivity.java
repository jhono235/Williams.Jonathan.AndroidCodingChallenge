package com.example.williamsjonathanandroidcodingchallenge.view.activities.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;

import com.example.williamsjonathanandroidcodingchallenge.R;
import com.example.williamsjonathanandroidcodingchallenge.view.adapters.MainActivityRvAdapter;

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    RecyclerView rvMainActivity;

    MainActivityPresenter mainActivityPresenter;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMainActivity = findViewById(R.id.rvBookList);

        mainActivityPresenter = new MainActivityPresenter(this);


        





    }

    @Override
    public void onAdapterReady(MainActivityRvAdapter adapter) {
        rvMainActivity.setLayoutManager(new LinearLayoutManager(this));
        rvMainActivity.setAdapter(adapter);
        rvMainActivity.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));




    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityPresenter.getBooks();
    }
}
