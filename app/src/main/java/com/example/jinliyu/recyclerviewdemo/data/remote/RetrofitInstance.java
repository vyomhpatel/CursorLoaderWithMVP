package com.example.jinliyu.recyclerviewdemo.data.remote;

//http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?mobile=55565454&password=7011

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                            .baseUrl("http://rjtmobile.com/aamir/e-commerce/android-app/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }
        return retrofit;
    }
}
