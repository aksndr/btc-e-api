package ru.avks.btce.model;


import ru.avks.btce.model.TradesReturn;

import java.util.Collection;

public class TradesObject {

    private Collection<TradesReturn> tradesReturns;

    public Collection<TradesReturn> getTradesReturns() {
        return tradesReturns;
    }

    public void setTradesReturns(Collection<TradesReturn> tradesReturns) {
        this.tradesReturns = tradesReturns;
    }
}
