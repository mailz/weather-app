package org.mailzz.weatherapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dmitriy Trandin on 25.10.2015.
 *
 * Splash activity, where app init
 */
public class ActivitySplash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //TODO check permission for gps for android 6

        //TODO check has GPS

        //init app
        final SharedPreferences preferences = WeatherApp.getInstance().getPreferences();
        int gender = preferences.getInt(WeatherApp.PREF_GENDER, -1);
        if(gender == -1){
            //show gender dialog
            AlertDialog genderDialog = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle(R.string.gender_choise)
                    .setMessage(R.string.check_gender_question)
                    .setPositiveButton(R.string.man_title, (dialog, which) -> {
                        preferences.edit().putInt(WeatherApp.PREF_GENDER, WeatherApp.MAN).apply();
                        dialog.dismiss();
                        startMainActivity();
                    })
                    .setNegativeButton(R.string.цщьфт_ешеду, ((dialog, which) -> {
                        preferences.edit().putInt(WeatherApp.PREF_GENDER, WeatherApp.WOMAN).apply();
                        dialog.dismiss();
                        startMainActivity();
                    }))
                    .create();
            genderDialog.show();
        }else{
            startMainActivity();
        }
    }

    private void startMainActivity(){
        Intent intent = new Intent(ActivitySplash.this, ActivityMain.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivitySplash.this.startActivity(intent);
        ActivitySplash.this.finish();
    }

}


