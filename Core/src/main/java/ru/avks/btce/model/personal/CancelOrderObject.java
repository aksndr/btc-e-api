package ru.avks.btce.model.personal;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import ru.avks.btce.model.common.Result;

import java.math.BigDecimal;

public class CancelOrderObject extends Result {

    @SerializedName("return")
    private Return cancelObjectReturn;

    public static CancelOrderObject getCancelOrderObject(String jsonString) {
        Gson gson = new Gson();
        CancelOrderObject cancelOrderObject = null;
        try {
            cancelOrderObject = gson.fromJson(jsonString, CancelOrderObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return cancelOrderObject;
    }

    public long getOrderId() {
        return cancelObjectReturn.order_id;
    }

    public BigDecimal getUsd() {
        return cancelObjectReturn.funds.usd;
    }

    public BigDecimal getBtc() {
        return cancelObjectReturn.funds.btc;
    }

    public BigDecimal getLtc() {
        return cancelObjectReturn.funds.ltc;
    }

    public BigDecimal getNmc() {
        return cancelObjectReturn.funds.nmc;
    }

    public BigDecimal getRur() {
        return cancelObjectReturn.funds.rur;
    }

    public BigDecimal getEur() {
        return cancelObjectReturn.funds.eur;
    }

    public BigDecimal getNvc() {
        return cancelObjectReturn.funds.nvc;
    }

    public BigDecimal getTrc() {
        return cancelObjectReturn.funds.trc;
    }

    public BigDecimal getPpc() {
        return cancelObjectReturn.funds.ppc;
    }

    public BigDecimal getFtc() {
        return cancelObjectReturn.funds.ftc;
    }

    public BigDecimal getXpm() {
        return cancelObjectReturn.funds.xpm;
    }


    private class Return {

        private long order_id;

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
