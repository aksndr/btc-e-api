package ru.avks.btce.model;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.math.BigDecimal;

public class TickerObject {

    private Ticker ticker;

    public static TickerObject getTickerObject(String jsonString) {
        Gson gson = new Gson();
        TickerObject tickerObject = null;
        try {
            tickerObject = gson.fromJson(jsonString, TickerObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return tickerObject;
    }

    public BigDecimal getHigh() {
        return ticker.high;
    }

    public BigDecimal getLow() {
        return ticker.low;
    }

    public BigDecimal getAvg() {
        return ticker.avg;
    }

    public BigDecimal getVol() {
        return ticker.vol;
    }

    public BigDecimal getVolCur() {
        return ticker.vol_cur;
    }

    public BigDecimal getLast() {
        return ticker.last;
    }

    public BigDecimal getBuy() {
        return ticker.buy;
    }

    public BigDecimal getSell() {
        return ticker.sell;
    }

    public long getUpdated() {
        return ticker.updated;
    }

    public long getServerTime() {
        return ticker.server_time;
    }

    private class Ticker {

        public BigDecimal high;

        public BigDecimal low;

        public BigDecimal avg;

        public BigDecimal vol;

        public BigDecimal vol_cur;

        public BigDecimal last;

        public BigDecimal buy;

        public BigDecimal sell;

        public long updated;

        public long server_time;
    }

}
