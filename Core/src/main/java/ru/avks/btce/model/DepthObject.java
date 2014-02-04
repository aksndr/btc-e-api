package ru.avks.btce.model;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.math.BigDecimal;

public class DepthObject {

    private BigDecimal[][] asks;

    private BigDecimal[][] bids;

    public static DepthObject getDepthObject(String jsonString) {
        Gson gson = new Gson();
        DepthObject depthObject = null;
        try {
            depthObject = gson.fromJson(jsonString, DepthObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return depthObject;
    }

    public BigDecimal[][] getAsks() {
        return asks;
    }

    public BigDecimal[][] getBids() {
        return bids;
    }
}
