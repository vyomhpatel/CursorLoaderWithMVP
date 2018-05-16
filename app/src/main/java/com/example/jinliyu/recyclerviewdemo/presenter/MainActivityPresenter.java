package com.example.jinliyu.recyclerviewdemo.presenter;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.jinliyu.recyclerviewdemo.R;
import com.example.jinliyu.recyclerviewdemo.data.remote.APIInterface;
import com.example.jinliyu.recyclerviewdemo.data.remote.RetrofitInstance;
import com.example.jinliyu.recyclerviewdemo.database.DBHelper;
import com.example.jinliyu.recyclerviewdemo.database.MyCursorLoader;
import com.example.jinliyu.recyclerviewdemo.model.UserModel;
import com.example.jinliyu.recyclerviewdemo.view.MainActivity;
import com.example.jinliyu.recyclerviewdemo.view.MainActivityContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter implements MainActivityContract.IPresenter, LoaderManager.LoaderCallbacks<Cursor> {

    private MainActivityContract.IView iView;
    private Context context;
    private MainActivity mainActivity;
    private APIInterface apiInterface;
    private DBHelper dbHelper;
    private static final String TAG = "tag";
    private CursorAdapter cursorAdapter;

    public MainActivityPresenter(MainActivity mainActivity) {
        this.context = mainActivity;
        this.mainActivity = mainActivity;
        this.iView = mainActivity;
        apiInterface = RetrofitInstance.getInstance().create(APIInterface.class);
        dbHelper = new DBHelper(context);
        cursorAdapter = new SimpleCursorAdapter(mainActivity, R.layout.item_layout,null,new String[]{"firstname"},
                new int[] { R.id.item_name});

    }

    public void addDataToLocal() {
        Call<List<UserModel>> retrofitCall = apiInterface.getUsers("55565454", "7011");
        retrofitCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    UserModel userModel = response.body().get(i);
                    dbHelper.insertUser(userModel.getFirstname(),userModel.getLastname(),userModel.getEmail()
                            ,userModel.getMobile(),userModel.getAppapikey());
                }

                Cursor cursor = dbHelper.selectAllUsers();
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndex("firstname"));
                Log.i(TAG, "onResponse: "+name);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.i("ON FAILUE", "Message:" + t.getMessage());
            }
        });


    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MyCursorLoader(context);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);
        iView.setAdapter(cursorAdapter);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        loader = null;
    }
}
