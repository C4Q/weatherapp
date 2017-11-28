package com.charlesdrews.charlesdrewsc4qweatherapp.data;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by charlie on 11/28/17.
 */

public interface WeatherRepository {
    void getForecast(String zipCode, WeatherCallback weatherCallback);

    interface WeatherCallback {
        void requestComplete(@Nullable List<ForecastDay> forecastDays,
                             @Nullable String errorMessage
        );
    }
}
