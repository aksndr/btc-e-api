package ru.avks.btce.model.personal;

public class TransactionHistoryOrder {

    private long transId;

    private TransactionHistoryDetails transactionDetails;

    public long getTransId() {
        return transId;
    }

    public TransactionHistoryDetails getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransId(long transId) {
        this.transId = transId;
    }

    public void setTransactionDetails(TransactionHistoryDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
