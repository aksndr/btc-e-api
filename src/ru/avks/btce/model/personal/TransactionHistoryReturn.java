package ru.avks.btce.model.personal;

import java.util.List;

public class TransactionHistoryReturn {

    private TransactionHistoryOrder[] transactions;

    public void setTransactions(TransactionHistoryOrder[] transactions) {
        this.transactions = transactions;
    }

    public TransactionHistoryOrder[] getTransactions() {
        return transactions;
    }
}
