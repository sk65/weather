package com.example.tabtest.model;

import android.widget.ImageView;
import android.widget.TextView;

public class DayWeatherCardModel {
    private TextView textViewCurrentTime;
    private TextView textViewCurrentTimeTemperature;
    private TextView textViewCurrentWindSpeed;
    private ImageView imageViewWeatherIcon;
    private ImageView imageViewWindDirection;

    public DayWeatherCardModel(TextView textViewCurrentTime,
                               TextView textViewCurrentTimeTemperature,
                               TextView textViewCurrentWindSpeed,
                               ImageView imageViewWeatherIcon,
                               ImageView imageViewWindDirection) {
        this.textViewCurrentTime = textViewCurrentTime;
        this.textViewCurrentTimeTemperature = textViewCurrentTimeTemperature;
        this.textViewCurrentWindSpeed = textViewCurrentWindSpeed;
        this.imageViewWeatherIcon = imageViewWeatherIcon;
        this.imageViewWindDirection = imageViewWindDirection;
    }

    public TextView getTextViewCurrentTime() {
        return textViewCurrentTime;
    }

    public TextView getTextViewCurrentTimeTemperature() {
        return textViewCurrentTimeTemperature;
    }

    public TextView getTextViewCurrentWindSpeed() {
        return textViewCurrentWindSpeed;
    }

    public ImageView getImageViewWeatherIcon() {
        return imageViewWeatherIcon;
    }

    public ImageView getImageViewWindDirection() {
        return imageViewWindDirection;
    }
}
