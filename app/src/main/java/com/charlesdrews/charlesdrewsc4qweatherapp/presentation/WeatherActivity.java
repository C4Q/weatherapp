package com.charlesdrews.charlesdrewsc4qweatherapp.presentation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.charlesdrews.charlesdrewsc4qweatherapp.R;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.ForecastDay;

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

        ImageView imageView = findViewById(R.id.image_view);
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable = getDrawable(R.drawable.am_pcloudy);
        } else {
            drawable = getResources().getDrawable(R.drawable.am_pcloudy);
        }
        imageView.setImageDrawable(drawable);

        // Test ViewModel
        weatherViewModel = ViewModelProviders.of(this, new WeatherViewModel.Factory())
                .get(WeatherViewModel.class);

        weatherViewModel.getForecast().observe(this, new Observer<List<ForecastDay>>() {
            @Override
            public void onChanged(@Nullable List<ForecastDay> forecastDays) {
                for (ForecastDay forecastDay : forecastDays) {
                    Log.d(TAG, "onChanged: " + forecastDay.getDate().toString());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
