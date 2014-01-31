package ru.avks.btce.model.personal;

import java.math.BigDecimal;

public class ActiveOrdersDetails {

    private String pair;

    private String type;

    private BigDecimal amount;

    private BigDecimal rate;

    private long timestampCreated;

    private int status;

    public String getPair() {
        return pair;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public long getTimestampCreated() {
        return timestampCreated;
    }

    public int getStatus() {
        return status;
    }
}
