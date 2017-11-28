package com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json;

/**
 * Created by charlie on 11/28/17.
 */

public class AerisPeriod {
    private String dateTimeISO, icon;
    private int maxTempC, maxTempF, minTempC, minTempF;

    public AerisPeriod(String dateTimeISO, String icon, int maxTempC, int maxTempF, int minTempC, int minTempF) {
        this.dateTimeISO = dateTimeISO;
        this.icon = icon;
        this.maxTempC = maxTempC;
        this.maxTempF = maxTempF;
        this.minTempC = minTempC;
        this.minTempF = minTempF;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public String getIcon() {
        return icon;
    }

    public int getMaxTempC() {
        return maxTempC;
    }

    public int getMaxTempF() {
        return maxTempF;
    }

    public int getMinTempC() {
        return minTempC;
    }

    public int getMinTempF() {
        return minTempF;
    }
}
