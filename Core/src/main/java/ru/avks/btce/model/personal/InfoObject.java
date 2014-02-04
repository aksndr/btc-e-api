package ru.avks.btce.model.personal;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import ru.avks.btce.model.common.Result;

import java.math.BigDecimal;

public class InfoObject extends Result {

    @SerializedName("return")
    private Return infoObjectReturn;

    public static InfoObject getInfoObject(String jsonString) {
        Gson gson = new Gson();
        InfoObject infoObject = null;
        try {
            infoObject = gson.fromJson(jsonString, InfoObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return infoObject;
    }

    public int getTransactionCount() {
        return infoObjectReturn.transaction_count;
    }

    public int getOpenOrders() {
        return infoObjectReturn.open_orders;
    }

    public long getServerTime() {
        return infoObjectReturn.server_time;
    }

    public BigDecimal getUSD() {
        return infoObjectReturn.funds.usd;
    }

    public BigDecimal getBTC() {
        return infoObjectReturn.funds.btc;
    }

    public BigDecimal getLTC() {
        return infoObjectReturn.funds.ltc;
    }

    public BigDecimal getNMC() {
        return infoObjectReturn.funds.nmc;
    }

    public BigDecimal getRUR() {
        return infoObjectReturn.funds.rur;
    }

    public BigDecimal getEUR() {
        return infoObjectReturn.funds.eur;
    }

    public BigDecimal getNVC() {
        return infoObjectReturn.funds.nvc;
    }

    public BigDecimal getTRC() {
        return infoObjectReturn.funds.trc;
    }

    public BigDecimal getPPC() {
        return infoObjectReturn.funds.ppc;
    }

    public BigDecimal getFTC() {
        return infoObjectReturn.funds.ftc;
    }

    public BigDecimal getXPM() {
        return infoObjectReturn.funds.xpm;
    }

    public int getInfo() {
        return infoObjectReturn.rights.info;
    }

    public int getTrade() {
        return infoObjectReturn.rights.trade;
    }

    public int getWithdraw() {
        return infoObjectReturn.rights.withdraw;
    }

    private class Return {

        public Funds funds;

        public Rights rights;

        public int transaction_count;

        public int open_orders;

        public long server_time;


        public class Funds {

            public BigDecimal usd;

            public BigDecimal btc;

            public BigDecimal ltc;

            public BigDecimal nmc;

            public BigDecimal rur;

            public BigDecimal eur;

            public BigDecimal nvc;

            public BigDecimal trc;

            public BigDecimal ppc;

            public BigDecimal ftc;

            public BigDecimal xpm;
        }

        public class Rights {

            public int info;

            public int trade;

            public int withdraw;
        }
    }
}
