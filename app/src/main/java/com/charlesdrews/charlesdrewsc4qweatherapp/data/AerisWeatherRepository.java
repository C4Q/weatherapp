package com.charlesdrews.charlesdrewsc4qweatherapp.data;

import android.util.Log;

import com.charlesdrews.charlesdrewsc4qweatherapp.data.network.AerisJsonToJavaConverter;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.network.AerisService;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json.AerisPeriod;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json.AerisResponse;
import com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json.AerisRoot;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by charlie on 11/28/17.
 */

public class AerisWeatherRepository implements WeatherRepository {

    private static final String TAG = "AerisWeatherRepository";

    /* Note: In production code I would further obfuscate these so they couldn't be found
                by simply decompiling the apk. But for this sample app, I think this is OK.
     */
    private static final String CLIENT_ID = "iyZVZHncYtdQGErl0DsDv";
    private static final String CLIENT_SECRET = "wAiR9tyiJjqh4c5sVy17tytzueAGAcfaYCdo1NBs";

    private static final String AERIS_BASE_URL = "http://api.aerisapi.com/";

    private static final String ERROR_MESSAGE = "Unable to retrieve weather data";


    /* For this sample app the NYC zip is hardcoded, but for a production app, this could be
        passed in as a parameter based on the device's current location.
     */
    public static final String ZIP_CODE = "11101";


    @Override
    public void getForecast(String zipCode, final WeatherCallback weatherCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AERIS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AerisService service = retrofit.create(AerisService.class);

        Call<AerisRoot> call = service.getForecast(ZIP_CODE, CLIENT_ID, CLIENT_SECRET);

        // Use enqueue to make network request from background thread
        call.enqueue(new Callback<AerisRoot>() {
            @Override
            public void onResponse(Call<AerisRoot> call, Response<AerisRoot> response) {
                Log.d(TAG, "onResponse: " + call.request().url().toString());
                if (response.isSuccessful()) {
                    AerisRoot aerisRoot = response.body();

                    if (aerisRoot != null && aerisRoot.isSuccess()) {

                        if (aerisRoot.isSuccess()) {
                            AerisResponse aerisResponse = aerisRoot.getResponse().get(0);

                            if (aerisResponse != null) {
                                // If all went well, construct List of ForecastDay objects
                                List<ForecastDay> forecastDays = new ArrayList<>();
                                for (AerisPeriod aerisPeriod : aerisResponse.getPeriods()) {
                                    ForecastDay forecastDay = AerisJsonToJavaConverter.convert(aerisPeriod);
                                    if (forecastDay != null) {
                                        forecastDays.add(forecastDay);
                                    }
                                }

                                // Send that List to the callback
                                weatherCallback.requestComplete(forecastDays, null);
                                return;
                            } else {
                                Log.d(TAG, "onResponse: request returned without data");
                            }
                        } else {
                            Log.d(TAG, "onResponse: request returned unsuccessfully" + aerisRoot.getError().getDescription());
                        }
                    } else {
                        Log.d(TAG, "onResponse: request failed");
                    }
                }
                weatherCallback.requestComplete(null, ERROR_MESSAGE);
            }

            @Override
            public void onFailure(Call<AerisRoot> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
                weatherCallback.requestComplete(null, ERROR_MESSAGE);
            }
        });
    }
}
