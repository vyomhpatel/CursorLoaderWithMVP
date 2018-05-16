package com.example.jinliyu.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<UserModel> list;
List<String> slist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<UserModel>();
        APIInterface apiInterface = RetrofitInstance.getInstance().create(APIInterface.class);

        Call<List<UserModel>> retrofitCall = apiInterface.getUsers("55565454", "7011");
        retrofitCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    UserModel userModel = (UserModel) response.body().get(i);
                    slist.add(userModel.getFirstname());
                    slist.add(userModel.getEmail());
                    slist.add(userModel.getMobile());
                }

                StringAdapter stringAdapter = new StringAdapter(MainActivity.this, slist);

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                stringAdapter.notifyDataSetChanged();

                recyclerView.setAdapter(stringAdapter);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.i("ON FAILUE", "Message:" + t.getMessage());
            }
        });

        recyclerView = findViewById(R.id.rv);





        StringAdapter stringAdapter = new StringAdapter(MainActivity.this, slist);

       recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

       stringAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(stringAdapter);




    }
}
