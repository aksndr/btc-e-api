package ru.avks.btce.traider;

import org.apache.commons.codec.binary.Hex;
import ru.avks.btce.api.IBTCEPersonalAPI;
import ru.avks.btce.model.*;
import ru.avks.btce.model.personal.*;
import ru.avks.btce.net.HttpConnection;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Exchange implements IBTCEPersonalAPI {

    private String key;

    private String secret;

    private HttpConnection httpConnection;

    private Pair currencyObject;


    public Exchange(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }


    public void setCurrencyObject(Enum currencyType) {
        this.currencyObject = new Pair(currencyType.toString());
    }

    public void setHttpConnection(HttpConnection connection) {
        this.httpConnection = connection;
    }


    public FeeObject getFee() {
        return FeeObject.getFeeObject(httpConnection.sendGet(currencyObject.getFee()));
    }

    public TickerObject getTicker() {
        return TickerObject.getTickerObject(httpConnection.sendGet(currencyObject.getTicker()));
    }

    public TradesObject getTrades() {
        TradesObject tradesObject = new TradesObject();
        tradesObject.setTradesReturns(TradesReturn.getTradesObject(httpConnection.sendGet(currencyObject.getTrades())));
        return tradesObject;
    }

    public DepthObject getDepth() {
        return DepthObject.getDepthObject(httpConnection.sendGet(currencyObject.getDepth()));
    }

    public InfoObject getInfo() {
        Map<String, String> postParam = new HashMap<String, String>(1);
        postParam.put("method", "getInfo");
        return InfoObject.getInfoObject(httpConnection.sendPost(HTTP_URL_TAPI, sign(postParam)));
    }

    @Override
    public TransactionHistoryObject transactionHistory(int from, int count, int fromId, int endId, String order, long since, long end) {
        Map<String, String> postParam = new HashMap<String, String>(8);
        postParam.put("method", "TransHistory");
        postParam.put("from", String.valueOf(from));
        postParam.put("count", String.valueOf(count));
        postParam.put("fromId", String.valueOf(fromId));
        postParam.put("endId", String.valueOf(endId));
        postParam.put("order", order);
        postParam.put("since", String.valueOf(since));
        postParam.put("end", String.valueOf(end));
        return TransactionHistoryObject.getTransactionHistoryObject(httpConnection.sendPost(HTTP_URL_TAPI, sign(postParam)));
    }

    @Override
    public TradeHistoryObject tradeHistory(int from, int count, int fromId, int endId, String oder, long since, long end, String pair) {
        return null;
    }

    @Override
    public ActiveOrdersObject activeOrders(String pair) {
        Map<String, String> postParam = new HashMap<String, String>(2);
        postParam.put("method", "ActiveOrders");
        postParam.put("pair", pair);
        return ActiveOrdersObject.getTransactionHistoryObject(httpConnection.sendPost(HTTP_URL_TAPI, sign(postParam)));
    }

    @Override
    public TradeObject trade(String pair, String type, int rate, int amount) {
        Map<String, String> postParam = new HashMap<String, String>(5);
        postParam.put("method", "Trade");
        postParam.put("pair", pair);
        postParam.put("type", type);
        postParam.put("rate", String.valueOf(rate));
        postParam.put("amount", String.valueOf(amount));
        return TradeObject.getTradeObject(httpConnection.sendPost(HTTP_URL_TAPI, sign(postParam)));
    }

    @Override
    public CancelOrderObject cancelOrder(long orderId) {
        Map<String, String> postParam = new HashMap<String, String>(2);
        postParam.put("method", "CancelOrder");
        postParam.put("order_id", String.valueOf(orderId));
        return CancelOrderObject.getCancelOrderObject(httpConnection.sendPost(HTTP_URL_TAPI, sign(postParam)));
    }

    private synchronized Map<String, String> sign(Map<String, String> param) {
        long nonce = (System.nanoTime() / 100000);

        HashMap<String, String> sendData = new HashMap<String, String>();

        param.put("nonce", "" + nonce);

        String postData = "";

        for (Map.Entry<String, String> entry : param.entrySet()) {
            Map.Entry argument = (Map.Entry) entry;
            if (postData.length() > 0) {
                postData += "&";
            }
            postData += argument.getKey() + "=" + argument.getValue();
        }

        sendData.put("postData", postData);

        try {
            SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA512");
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(keySpec);
            sendData.put("Key", key);
            sendData.put("Sign", Hex.encodeHexString(mac.doFinal(postData.getBytes("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return sendData;
    }

}
