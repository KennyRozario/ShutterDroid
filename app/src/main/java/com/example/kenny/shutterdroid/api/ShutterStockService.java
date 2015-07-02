package com.example.kenny.shutterdroid.api;

import javax.security.auth.callback.Callback;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Kenny on 15-07-01.
 */
interface ShutterStockService {
    @GET("/images/search")
    public void search(@Query("query") String query, retrofit.Callback<Response> cb);

    @GET("/images/search")
    public void getRecent(@Query("added_date_start") String date, retrofit.Callback<Response> cb);
}
