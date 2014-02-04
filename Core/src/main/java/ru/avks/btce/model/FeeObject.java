package ru.avks.btce.model;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.math.BigDecimal;

public class FeeObject {

    private BigDecimal trade;


    public static FeeObject getFeeObject(String jsonString) {
        Gson gson = new Gson();
        FeeObject feeObject = null;
        try {
            feeObject = gson.fromJson(jsonString, FeeObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return feeObject;
    }

    public BigDecimal getFee() {
        return trade;
    }
}
