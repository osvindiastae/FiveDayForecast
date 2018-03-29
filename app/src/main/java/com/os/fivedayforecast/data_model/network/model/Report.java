package com.os.fivedayforecast.data_model.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Os on 27/03/2018.
 */

public class Report {

    @SerializedName("dt")
    @Expose
    private Integer dateTimeNumber;
    @SerializedName("main")
    @Expose
    private MainBody mainBody;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("rain")
    @Expose
    private Rain rain;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("dt_txt")
    @Expose
    private String dateTimeText;

    public Integer getDateTimeNumber() {
        return dateTimeNumber;
    }

    public void setDateTimeNumber(Integer dateTimeNumber) {
        this.dateTimeNumber = dateTimeNumber;
    }

    public MainBody getMainBody() {
        return mainBody;
    }

    public void setMain(MainBody mainBody) {
        this.mainBody = mainBody;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDateTimeText() {
        return dateTimeText;
    }

    public void setDateTimeText(String dateTimeText) {
        this.dateTimeText = dateTimeText;
    }

}
