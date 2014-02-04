package ru.avks.btce.model.personal;


public class ActiveOrdersReturn {

    private ActiveOrdersOrder[] orders;

    public ActiveOrdersOrder[] getOrders() {
        return orders;
    }

    public void setOrders(ActiveOrdersOrder[] orders) {
        this.orders = orders;
    }
}
