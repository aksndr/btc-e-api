package ru.avks.btce.model.personal;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import ru.avks.btce.model.common.Result;

import java.math.BigDecimal;

public class TradeObject extends Result {

    @SerializedName("return")
    private Return tradeObjectReturn;

    public static TradeObject getTradeObject(String jsonString) {
        Gson gson = new Gson();
        TradeObject tradeObject = null;
        try {
            tradeObject = gson.fromJson(jsonString, TradeObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return tradeObject;
    }

    public BigDecimal getReceived() {
        return tradeObjectReturn.received;
    }

    public BigDecimal getRemains() {
        return tradeObjectReturn.remains;
    }

    public long getOrderId() {
        return tradeObjectReturn.order_id;
    }

    public BigDecimal getUsd() {
        return tradeObjectReturn.funds.usd;
    }

    public BigDecimal getBtc() {
        return tradeObjectReturn.funds.btc;
    }

    public BigDecimal getLtc() {
        return tradeObjectReturn.funds.ltc;
    }

    public BigDecimal getNmc() {
        return tradeObjectReturn.funds.nmc;
    }

    public BigDecimal getRur() {
        return tradeObjectReturn.funds.rur;
    }

    public BigDecimal getEur() {
        return tradeObjectReturn.funds.eur;
    }

    public BigDecimal getNvc() {
        return tradeObjectReturn.funds.nvc;
    }

    public BigDecimal getTrc() {
        return tradeObjectReturn.funds.trc;
    }

    public BigDecimal getPpc() {
        return tradeObjectReturn.funds.ppc;
    }

    public BigDecimal getFtc() {
        return tradeObjectReturn.funds.ftc;
    }

    public BigDecimal getXpm() {
        return tradeObjectReturn.funds.xpm;
    }


    private class Return {

        private BigDecimal received;

        private BigDecimal remains;

        public long order_id;

        public Funds funds;

        public class Funds {

            private BigDecimal usd;

            private BigDecimal btc;

            private BigDecimal ltc;

            private BigDecimal nmc;

            private BigDecimal rur;

            private BigDecimal eur;

            private BigDecimal nvc;

            private BigDecimal trc;

            private BigDecimal ppc;

            private BigDecimal ftc;

            private BigDecimal xpm;
        }
    }
}
