package com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json;

import java.util.ArrayList;

/**
 * Created by charlie on 11/28/17.
 */

public class AerisResponse {
    private ArrayList<AerisPeriod> periods;

    public AerisResponse(ArrayList<AerisPeriod> periods) {
        this.periods = periods;
    }

    public ArrayList<AerisPeriod> getPeriods() {
        return periods;
    }
}
