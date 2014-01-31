package ru.avks.btce.net;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpConnection {

    private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31";

    private boolean proxy;

    private String proxyHost;

    private int proxyPort;

    private String user;

    private String password;

    public HttpConnection() {
        this.proxy = false;
    }

    public HttpConnection(String proxyHost, int proxyPort, String user, String password) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.user = user;
        this.password = password;
        this.proxy = true;
    }

    public String sendGet(String url) {
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection;
        try {
            URL urlObj = new URL(url);
            if (proxy) {
                setProxy();
                connection = (HttpURLConnection) urlObj.openConnection();
            } else {
                connection = (HttpURLConnection) urlObj.openConnection();
            }

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    public String sendPost(String url, Map<String, String> sendData) {
        StringBuilder response = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection;
            if (proxy) {
                setProxy();
                connection = (HttpURLConnection) urlObj.openConnection();
            } else {
                connection = (HttpURLConnection) urlObj.openConnection();
            }

            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestProperty("Key", sendData.get("Key"));
            connection.setRequestProperty("Sign", sendData.get("Sign"));

            connection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(sendData.get("postData"));
            dataOutputStream.flush();
            dataOutputStream.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    private void setProxy() {
        Authenticator.setDefault(new ProxyAuthenticator(user, password));
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", String.valueOf(proxyPort));
    }

}
