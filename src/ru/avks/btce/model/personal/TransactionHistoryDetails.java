package ru.avks.btce.model.personal;

import java.math.BigDecimal;

public class TransactionHistoryDetails {

    private String id;

    private int type;

    private BigDecimal amount;

    private String currency;

    private String desc;

    private int status;

    private long timestamp;

    public String getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDesc() {
        return desc;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
