package com.charlesdrews.charlesdrewsc4qweatherapp.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.charlesdrews.charlesdrewsc4qweatherapp.data.AerisWeatherRepository;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.ForecastDay;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.WeatherRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charlie on 11/28/17.
 */

public class WeatherViewModel extends ViewModel {

    private WeatherRepository weatherRepository;

    private MutableLiveData<List<ForecastDay>> forecast;

    public WeatherViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public LiveData<List<ForecastDay>> getForecast() {
        if (forecast == null) {
            forecast = new MutableLiveData<List<ForecastDay>>();
        }

        weatherRepository.getForecast(AerisWeatherRepository.ZIP_CODE, new WeatherRepository.WeatherCallback() {
            @Override
            public void requestComplete(@Nullable List<ForecastDay> forecastDays, @Nullable String errorMessage) {
                if (forecastDays != null) {
                    forecast.setValue(new ArrayList<ForecastDay>(forecastDays));
                }
            }
        });
        return forecast;
    }


    public static class Factory implements ViewModelProvider.Factory {

        @NonNull
        @Override
        @SuppressWarnings("unchecked")
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(WeatherViewModel.class)) {
                return (T) new WeatherViewModel(new AerisWeatherRepository());
            }
            throw new IllegalArgumentException("Unknown class name");
        }
    }
}
