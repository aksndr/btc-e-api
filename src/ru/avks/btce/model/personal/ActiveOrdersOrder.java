package ru.avks.btce.model.personal;


public class ActiveOrdersOrder {

    private long orderId;
    private ActiveOrdersDetails orderDetails;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public ActiveOrdersDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ActiveOrdersDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
