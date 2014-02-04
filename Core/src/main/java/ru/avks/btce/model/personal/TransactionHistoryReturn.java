package ru.avks.btce.model.personal;

public class TransactionHistoryReturn {

    private TransactionHistoryOrder[] transactions;

    public void setTransactions(TransactionHistoryOrder[] transactions) {
        this.transactions = transactions;
    }

    public TransactionHistoryOrder[] getTransactions() {
        return transactions;
    }
}
