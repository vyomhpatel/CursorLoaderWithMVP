package com.example.jinliyu.recyclerviewdemo.view;

import android.widget.CursorAdapter;
import android.widget.ListView;

public interface MainActivityContract {

    public interface IView{

        void setAdapter(CursorAdapter cursorAdapter);
    }

    public interface IPresenter{

        void addDataToLocal();
    }

}
