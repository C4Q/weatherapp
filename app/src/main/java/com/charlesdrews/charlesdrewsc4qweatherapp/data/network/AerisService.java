package com.charlesdrews.charlesdrewsc4qweatherapp.data.network;

import com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json.AerisRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by charlie on 11/28/17.
 */

public interface AerisService {
    @GET("forecasts/{zip}")
    Call<AerisRoot> getForecast(
            @Path("zip") String zipCode,
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret
    );
}
