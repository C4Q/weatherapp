package com.charlesdrews.charlesdrewsc4qweatherapp.presentation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.charlesdrews.charlesdrewsc4qweatherapp.R;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.ForecastDay;

import java.util.List;
import java.util.Locale;

/**
 * Created by charlie on 11/28/17.
 */

public class WeatherRvAdapter extends RecyclerView.Adapter<WeatherRvAdapter.WeatherViewHolder> {

    private Context context;
    private List<ForecastDay> forecast;

    public WeatherRvAdapter(Context context, List<ForecastDay> forecast) {
        this.context = context;
        this.forecast = forecast;
    }

    public void updateForecast(List<ForecastDay> newForecast) {
        forecast.clear();
        forecast.addAll(newForecast);
        notifyDataSetChanged();
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WeatherViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_day, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        ForecastDay day = forecast.get(position);
        holder.date.setText(day.getDate().toString());

        int imageId = context.getResources().getIdentifier(day.getIconName(), "drawable", context.getPackageName());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(imageId));

        holder.forecast.setText(String.format(Locale.getDefault(),"High: %d F\nLow: %d F", day.getMaxTempF(), day.getMinTempF()));
    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        TextView date, forecast;
        ImageView imageView;

        public WeatherViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            forecast = itemView.findViewById(R.id.forecast);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
