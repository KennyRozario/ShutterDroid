package com.example.kenny.shutterdroid.api;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Kenny on 15-07-01.
 */
public class ShutterStock {
    private static final RestAdapter ADAPTER = new RestAdapter.Builder()
            .setEndpoint("https://api.shutterstock.com/v2")
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = "de5d2fd4c633f361d16c:fa6199e7322a1f312aa73ec52ea9ab221dd32b78";
                    String auth = "Basic " + Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", auth);
                }
            })
            .build();

    private static final ShutterStockService SERVICE = ADAPTER.create(ShutterStockService.class);

    public void search (String query, Callback<List<Image>> cb){
        SERVICE.search(query, new ImageCallback(cb));
    }

    public static void getRecent(Date date, Callback<List<Image>> cb){
        SERVICE.getRecent(new SimpleDateFormat("yyyy-MM-dd").format(date), new ImageCallback(cb));
    }

    private static class ImageCallback implements Callback<Response>{
        Callback<List<Image>> cb;
        ImageCallback(Callback<List<Image>> cb){
            this.cb = cb;
        }
        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data, response2);
        }

        @Override
        public void failure(RetrofitError error) {
            cb.failure(error);
        }
    }
}
