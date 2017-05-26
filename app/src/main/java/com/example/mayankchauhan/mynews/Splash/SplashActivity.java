package com.example.mayankchauhan.mynews.Splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mayankchauhan.mynews.Constant.Constants;
import com.example.mayankchauhan.mynews.OnScreen.OnScreenActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this,OnScreenActivity.class);
                startActivity(intent);
                finish();
            }
        }, Constants.TIME_OUT);
    }
}
