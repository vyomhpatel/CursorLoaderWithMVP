package com.example.jinliyu.recyclerviewdemo.data.remote;

import com.example.jinliyu.recyclerviewdemo.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("shop_login.php")
    Call<List<UserModel>> getUsers(@Query("mobile") String mobile, @Query("password") String password);
}
