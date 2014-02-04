package ru.avks.btce.model.personal;


import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import ru.avks.btce.model.common.Result;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionHistoryObject extends Result implements JsonDeserializer<TransactionHistoryReturn> {

    @SerializedName("return")
    private TransactionHistoryReturn transactionHistory;

    public static TransactionHistoryObject getTransactionHistoryObject(String jsonString) {
        GsonBuilder gson_builder = new GsonBuilder();
        gson_builder.registerTypeAdapter(TransactionHistoryReturn.class, new TransactionHistoryObject());
        Gson gson = gson_builder.create();
        TransactionHistoryObject transactionHistoryObject = null;
        try {
            transactionHistoryObject = gson.fromJson(jsonString, TransactionHistoryObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return transactionHistoryObject;
    }

    @Override
    public TransactionHistoryReturn deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        TransactionHistoryReturn transactionHistoryReturn = new TransactionHistoryReturn();
        List<TransactionHistoryOrder> transactions = new ArrayList<TransactionHistoryOrder>();
        if (jsonElement.isJsonObject()) {
            JsonObject o = jsonElement.getAsJsonObject();
            for (Map.Entry<String, JsonElement> jsonOrder : o.entrySet()) {
                TransactionHistoryOrder transaction = new TransactionHistoryOrder();
                transaction.setTransId(Long.parseLong(jsonOrder.getKey()));
                transaction.setTransactionDetails((TransactionHistoryDetails) jsonDeserializationContext.deserialize(jsonOrder.getValue(), TransactionHistoryDetails.class));
                transactions.add(transaction);
            }
        }

        transactionHistoryReturn.setTransactions(transactions.toArray(new TransactionHistoryOrder[0]));

        return transactionHistoryReturn;
    }

    public TransactionHistoryReturn getTransactionHistory() {
        return transactionHistory;
    }
}
