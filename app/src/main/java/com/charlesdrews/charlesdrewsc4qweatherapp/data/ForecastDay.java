package com.charlesdrews.charlesdrewsc4qweatherapp.data;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by charlie on 11/28/17.
 */

public class ForecastDay {
    private Date date;
    private int minTempF, maxTempF, minTempC, maxTempC;
    private String iconName;

    public ForecastDay(Date date, int minTempF, int maxTempF, int minTempC, int maxTempC, @NonNull String iconName) {
        this.date = date;
        this.minTempF = minTempF;
        this.maxTempF = maxTempF;
        this.minTempC = minTempC;
        this.maxTempC = maxTempC;
        this.iconName = iconName;
    }

    public Date getDate() {
        return date;
    }

    public int getMinTempF() {
        return minTempF;
    }

    public int getMaxTempF() {
        return maxTempF;
    }

    public int getMinTempC() {
        return minTempC;
    }

    public int getMaxTempC() {
        return maxTempC;
    }

    public String getIconName() {
        return iconName;
    }
}
