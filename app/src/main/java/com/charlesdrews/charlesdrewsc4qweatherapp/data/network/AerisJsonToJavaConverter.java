package com.charlesdrews.charlesdrewsc4qweatherapp.data.network;

import com.charlesdrews.charlesdrewsc4qweatherapp.data.ForecastDay;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json.AerisPeriod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by charlie on 11/28/17.
 */

public class AerisJsonToJavaConverter {
    public static ForecastDay convert(AerisPeriod aerisPeriod) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
        Date date;

        try {
            date = formatter.parse(aerisPeriod.getDateTimeISO());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return new ForecastDay(
                date,
                aerisPeriod.getMinTempF(),
                aerisPeriod.getMaxTempF(),
                aerisPeriod.getMinTempC(),
                aerisPeriod.getMaxTempC(),
                aerisPeriod.getIcon().substring(0, aerisPeriod.getIcon().indexOf('.'))
        );
    }
}
