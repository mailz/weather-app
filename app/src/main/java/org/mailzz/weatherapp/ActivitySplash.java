package org.mailzz.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ubick on 25.10.2015.
 */
public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO start activity
//        finish();
//        Intent cv =new Intent(MainActivity.this,HomeScreen.class/*otherclass*/);
//        startActivity(cv);
    }
}


