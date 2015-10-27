package org.mailzz.weatherapp.models;

/**
 * Created by Dmitriy Trandin on 28.10.2015.
 */
public class Sys {

    private float message;
    private String country;
    private long sunrise;
    private long sunset;

    public float getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
