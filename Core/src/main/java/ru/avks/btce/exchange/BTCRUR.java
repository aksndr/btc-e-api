package ru.avks.btce.exchange;


import ru.avks.btce.api.IBTCEPublicAPI;

public class BTCRUR implements IBTCEPublicAPI {

    private static final String PAIR = "btc_rur";

    public static String getPair() {
        return PAIR;
    }

    @Override
    public String getFee() {
        return HTTP_URL_API + "/" + PAIR + "/fee";
    }

    @Override
    public String getTicker() {
        return HTTP_URL_API + "/" + PAIR + "/ticker";
    }

    @Override
    public String getTrades() {
        return HTTP_URL_API + "/" + PAIR + "/trades";
    }

    @Override
    public String getDepth() {
        return HTTP_URL_API + "/" + PAIR + "/depth";
    }

}
