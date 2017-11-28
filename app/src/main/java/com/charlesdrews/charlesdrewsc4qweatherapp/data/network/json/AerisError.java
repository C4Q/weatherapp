package com.charlesdrews.charlesdrewsc4qweatherapp.data.network.json;

/**
 * Created by charlie on 11/28/17.
 */

public class AerisError {
    private String code, description;

    public AerisError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
