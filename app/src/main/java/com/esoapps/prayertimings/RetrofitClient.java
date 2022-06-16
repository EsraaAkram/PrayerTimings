package com.esoapps.prayertimings;


import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static final String BASE_URL = "http://sound.ossions.com/api/";
    //private static final String BASE_URL = "http://sound.morooo.space/api/";
    private static final String TAG = "RetrofitClient";
    private static Retrofit retrofit;

    public static RESTapis getRESTapis(Context context) {
        initRetrofitClient(context);
        return retrofit.create(RESTapis.class);
    }

    private static void initRetrofitClient(Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }


}

