package ru.avks.btce.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;

public class TradesReturn {

    public static Collection<TradesReturn> getTradesObject(String jsonString) {
        Gson gson = new Gson();
        TradesReturn tradesObject = new TradesReturn();
        Type collectionType = new TypeToken<Collection<TradesReturn>>() {
        }.getType();
        return gson.fromJson(jsonString, collectionType);
    }

    private long date;

    private BigDecimal price;

    private BigDecimal amount;

    private int tid;

    private String price_currency;

    private String item;

    private String trade_type;


    public long getDate() {
        return date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getTid() {
        return tid;
    }

    public String getPriceCurrency() {
        return price_currency;
    }

    public String getItem() {
        return item;
    }

    public String getTradeType() {
        return trade_type;
    }
}

