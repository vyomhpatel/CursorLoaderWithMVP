package com.example.jinliyu.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);


        List<String> slist = new ArrayList<String>();

        slist.add("first");
        slist.add("second");
        slist.add("third");
        slist.add("fourth");
        slist.add("first");
        slist.add("second");
        slist.add("third");
        slist.add("fourth");

        StringAdapter stringAdapter = new StringAdapter(MainActivity.this, slist);

       recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

       stringAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(stringAdapter);




    }
}
