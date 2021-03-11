package com.example.tabtest.model;

import android.widget.ImageView;
import android.widget.TextView;

public class DayWeatherCardModel {
    private String textViewCurrentTime;
    private String textViewCurrentTimeTemperature;
    private String textViewCurrentWindSpeed;
    private int imageViewWeatherIcon;
    private int imageViewWindDirection;

    public DayWeatherCardModel(String textViewCurrentTime,
                               String textViewCurrentTimeTemperature,
                               String textViewCurrentWindSpeed,
                               int imageViewWeatherIcon,
                               int imageViewWindDirection) {
        this.textViewCurrentTime = textViewCurrentTime;
        this.textViewCurrentTimeTemperature = textViewCurrentTimeTemperature;
        this.textViewCurrentWindSpeed = textViewCurrentWindSpeed;
        this.imageViewWeatherIcon = imageViewWeatherIcon;
        this.imageViewWindDirection = imageViewWindDirection;
    }

    public String getTextViewCurrentTime() {
        return textViewCurrentTime;
    }

    public String getTextViewCurrentTimeTemperature() {
        return textViewCurrentTimeTemperature;
    }

    public String getTextViewCurrentWindSpeed() {
        return textViewCurrentWindSpeed;
    }

    public int getImageViewWeatherIcon() {
        return imageViewWeatherIcon;
    }

    public int getImageViewWindDirection() {
        return imageViewWindDirection;
    }
}
