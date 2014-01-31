package ru.avks.btce.api;


import ru.avks.btce.model.personal.*;

public interface IBTCEPersonalAPI {

    final String HTTP_URL_TAPI = "https://btc-e.com/tapi";

    InfoObject getInfo();

    TransactionHistoryObject transactionHistory(int from, int count, int fromId, int endId, String oder, long since, long end);

    TradeHistoryObject tradeHistory(int from, int count, int fromId, int endId, String oder, long since, long end, String pair);

    ActiveOrdersObject activeOrders(String pair);

    TradeObject trade(String pair, String type, int rate, int amount);

    CancelOrderObject cancelOrder(long orderId);

}
