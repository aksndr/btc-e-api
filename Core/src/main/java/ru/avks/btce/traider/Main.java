package ru.avks.btce.traider;


import ru.avks.btce.exchange.BTCRUR;
import ru.avks.btce.net.HttpConnection;

public class Main {

    private static final String KEY = "LNER8WSF-*";
    private static final String SECRET = "fecd7a6f3*";

    private static String proxyHost = "proxy.host.ru";
    private static int proxyPort = 3128;
    private static String user = "user";
    private static String password = "password";

    public static void main(String[] args) {
        HttpConnection httpConnection = new HttpConnection(proxyHost, proxyPort, user, password);
        //HttpConnection httpConnection = new HttpConnection();
        Exchange exchange = new Exchange(KEY, SECRET);
        exchange.setHttpConnection(httpConnection);
        exchange.setCurrencyObject(new BTCRUR());
    }
}
