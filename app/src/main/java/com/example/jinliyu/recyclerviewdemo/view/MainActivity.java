package com.example.jinliyu.recyclerviewdemo.view;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.jinliyu.recyclerviewdemo.R;
import com.example.jinliyu.recyclerviewdemo.adapters.StringAdapter;
import com.example.jinliyu.recyclerviewdemo.database.DBHelper;
import com.example.jinliyu.recyclerviewdemo.database.MyCursorLoader;
import com.example.jinliyu.recyclerviewdemo.model.UserModel;
import com.example.jinliyu.recyclerviewdemo.presenter.MainActivityPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.IView {
    private static final String TAG = "tag";
    RecyclerView recyclerView;
    List<UserModel> list;
    DBHelper dbHelper;
    StringAdapter stringAdapter;
    CursorAdapter cursorAdapter;
    ListView listView ;
    MainActivityContract.IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iPresenter = new MainActivityPresenter(this);
        iPresenter.addDataToLocal();
        getLoaderManager().initLoader(1, null, (MainActivityPresenter) iPresenter);
        listView = findViewById(R.id.listView);

    }


    @Override
    public void setAdapter(CursorAdapter cursorAdapter) {
        listView.setAdapter(cursorAdapter);
    }
}
