package com.example.gads2020;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPostClient {
    private static Retrofit retrofit = null;
//    private static final String BASE_URL = "https://docs.google.com/forms/d/e";

    public static Retrofit getRetrofitInstance(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder ()
//                    .baseUrl (BASE_URL)
                    .baseUrl (baseUrl)
                    .addConverterFactory (GsonConverterFactory.create ())
                    .build ();
        }
        return retrofit;
    }
}
