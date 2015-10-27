package org.mailzz.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by Dmitriy Trandin on 25.10.2015.
 */
public class ActivitySplash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = (int)(1000 * 0.5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //start app

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySplash.this, ActivityMain.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivitySplash.this.startActivity(intent);
                ActivitySplash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

}


