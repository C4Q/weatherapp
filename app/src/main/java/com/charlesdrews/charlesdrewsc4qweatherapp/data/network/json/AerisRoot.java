package com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charlie on 11/28/17.
 */

public class AerisRoot {
    private boolean success;
    private AerisError error;
    private List<AerisResponse> response;

    public AerisRoot(boolean success, AerisError error, ArrayList<AerisResponse> response) {
        this.success = success;
        this.error = error;
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public AerisError getError() {
        return error;
    }

    public List<AerisResponse> getResponse() {
        return response;
    }
}
