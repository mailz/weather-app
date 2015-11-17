package org.mailzz.weatherapp;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Dmitriy Trandin on 25.10.2015.
 *
 *
 */
public class WeatherApp extends Application {

    public static final String WEATHER_APP_PREFS = "WeatherAppPrefs";
    //prefs
    public static final String PREF_GENDER = "gender";
    public static final String PREF_LAST_CITY = "lastCity";
    public static final String PREF_LAST_LOCATION_LAT = "lat";
    public static final String PREF_LAST_LOCATION_LON = "lon";
    //consts
    public static final int MAN = 0;
    public static final int WOMAN = 1;

    private static WeatherApp instance;

    private SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        preferences = getSharedPreferences(WEATHER_APP_PREFS, MODE_PRIVATE);
    }

    public static WeatherApp getInstance(){
        if(instance != null){
            return instance;
        }else{
            throw new IllegalStateException("Application hasn't been init yet");
        }
    }

    public SharedPreferences getPreferences(){
        return preferences;
    }


}
