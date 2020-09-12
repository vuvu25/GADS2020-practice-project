package com.example.gads2020;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    public static Retrofit getRetrofitInstance (){
        if (retrofit == null){
            retrofit = new Retrofit.Builder ()
                    .baseUrl (BASE_URL)
                    .addConverterFactory (GsonConverterFactory.create ())
                    .build ();
        }
        return retrofit;
    }


}