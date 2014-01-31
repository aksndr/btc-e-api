package ru.avks.btce.api;

public interface IBTCEPublicAPI {

    final String HTTP_URL_API = "https://btc-e.com/api/2";

    String getFee();

    String getTicker();

    String getTrades();

    String getDepth();
}
