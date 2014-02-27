package ru.avks.btce.traider;

/**
 * User: a.arzamastsev Date: 27.02.14 Time: 15:57
 */
public class Pair {
    private final String HTTP_URL_API = "https://btc-e.com/api/2";
//    private static final String btc_rur = "btc_rur";
//    private static final String btc_usd = "btc_usd";
//    private static final String ltc_rur = "ltc_rur";

    private String pair;

    Pair(String pair) {
        this.pair = pair;
    }

    public String getPair() {
        return this.pair;
    }

    public String getFee() {
        return HTTP_URL_API + "/" + getPair() + "/fee";
    }

    public String getTicker() {
        return HTTP_URL_API + "/" + getPair() + "/ticker";
    }

    public String getTrades() {
        return HTTP_URL_API + "/" + getPair() + "/trades";
    }

    public String getDepth() {
        return HTTP_URL_API + "/" + getPair() + "/depth";
    }
}
