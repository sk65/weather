package com.example.tabtest.model;

public class WeatherParamCardModel {
    private String weatherDescription;
    private String weatherParam;

    public WeatherParamCardModel(String weatherDescription, String weatherParam) {
        this.weatherDescription = weatherDescription;
        this.weatherParam = weatherParam;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getWeatherParam() {
        return weatherParam;
    }
}
