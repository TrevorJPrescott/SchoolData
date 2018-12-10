package com.trevorpc.schooldata.client;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpHelper {

    OkHttpClient client;
    private Request request;

    public OkHttpHelper(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // https://data.cityofnewyork.us/resource/97mf-9njv.json
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("data.cityofnewyork.us/resource/97mf-9njv.json")
                .build();

        client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        request = new Request.Builder()
                .url(url)
                .build();

    }

    public void enqueueForSchoolNames() {

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();


//                RandomResponse randomResponse = gson.fromJson(response.body().string(), RandomResponse.class);
//
//                Log.d("TAG", "onResponse: Thread " + Thread.currentThread().getName());
//                Log.d("TAG", "onResponse: " + randomResponse.getResults().size());
            }
        });
    }

}
