package org.mailzz.weatherapp.models;

import java.util.List;

/**
 * Created by Dmitriy Trandin on 28.10.2015.
 */
public class CurrentWeather {

    private Coordinates coord;
    private List<Weather> weather;
    private String base;
    private MainParams main;
    private Wind wind;
    private RainSnow rain;
    private Clouds clouds;
    private RainSnow show;
    private long dt;
    private Sys sys;
    private long id;
    private String name;
    private int cod;

    public Coordinates getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainParams getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public RainSnow getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public RainSnow getShow() {
        return show;
    }

    public long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}
