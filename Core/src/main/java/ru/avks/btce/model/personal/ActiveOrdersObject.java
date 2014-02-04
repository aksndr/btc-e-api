package ru.avks.btce.model.personal;


import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import ru.avks.btce.model.common.Result;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActiveOrdersObject extends Result implements JsonDeserializer<ActiveOrdersReturn> {

    @SerializedName("return")
    private ActiveOrdersReturn activeOrders;

    public static ActiveOrdersObject getTransactionHistoryObject(String jsonString) {
        GsonBuilder gson_builder = new GsonBuilder();
        gson_builder.registerTypeAdapter(ActiveOrdersReturn.class, new ActiveOrdersObject());
        Gson gson = gson_builder.create();
        ActiveOrdersObject activeOrdersObject = null;
        try {
            activeOrdersObject = gson.fromJson(jsonString, ActiveOrdersObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return activeOrdersObject;
    }

    @Override
    public ActiveOrdersReturn deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ActiveOrdersReturn activeOrdersReturn = new ActiveOrdersReturn();
        List<ActiveOrdersOrder> orders = new ArrayList<ActiveOrdersOrder>();
        if (jsonElement.isJsonObject()) {
            JsonObject o = jsonElement.getAsJsonObject();
            for (Map.Entry<String, JsonElement> jsonOrder : o.entrySet()) {
                ActiveOrdersOrder order = new ActiveOrdersOrder();
                order.setOrderId(Long.parseLong(jsonOrder.getKey()));
                order.setOrderDetails((ActiveOrdersDetails) jsonDeserializationContext.deserialize(jsonOrder.getValue(), ActiveOrdersDetails.class));
                orders.add(order);
            }
        }

        activeOrdersReturn.setOrders(orders.toArray(new ActiveOrdersOrder[0]));

        return activeOrdersReturn;
    }

    public ActiveOrdersReturn getActiveOrders() {
        return activeOrders;
    }


}
