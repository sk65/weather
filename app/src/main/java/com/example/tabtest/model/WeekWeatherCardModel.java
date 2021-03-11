package com.example.tabtest.model;

public class WeekWeatherCardModel {
    private String weatherDesc;
    private String temperatureHolder;
    private String dayOfWeek;
    private int icon;

    public WeekWeatherCardModel(String weatherDesc, String temperatureHolder, String dayOfWeek, int icon) {
        this.weatherDesc = weatherDesc;
        this.temperatureHolder = temperatureHolder;
        this.dayOfWeek = dayOfWeek;
        this.icon = icon;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public String getTemperatureHolder() {
        return temperatureHolder;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getIcon() {
        return icon;
    }
}
