package com.charlesdrews.charlesdrewsc4qweatherapp.presentation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.charlesdrews.charlesdrewsc4qweatherapp.R;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.ForecastDay;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";

    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up recyclerview
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final WeatherRvAdapter adapter = new WeatherRvAdapter(this, new ArrayList<ForecastDay>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Get ViewModel & subscribe to forecast data
        weatherViewModel = ViewModelProviders.of(this, new WeatherViewModel.Factory())
                .get(WeatherViewModel.class);

        weatherViewModel.getForecast().observe(this, new Observer<List<ForecastDay>>() {
            @Override
            public void onChanged(@Nullable List<ForecastDay> forecastDays) {
                if (forecastDays != null) {
                    for (ForecastDay forecastDay : forecastDays) {
                        Log.d(TAG, "onChanged: " + forecastDay.getDate().toString());
                    }
                    adapter.updateForecast(forecastDays);
                }
            }
        });
    }
}
