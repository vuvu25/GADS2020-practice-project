package com.example.gads2020;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class Splash extends AppCompatActivity {
    @SuppressWarnings("FieldCanBeLocal")
    private static int SPLASH_DISPLAY_LENGTH=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash.this, MainActivity.class);
            Splash.this.startActivity(intent);
            Splash .this.finish();
        }, SPLASH_DISPLAY_LENGTH);


    }
}


 