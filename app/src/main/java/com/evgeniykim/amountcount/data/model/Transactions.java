package com.evgeniykim.amountcount.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transactions {

    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
