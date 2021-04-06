package com.evgeniykim.amountcount.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionsSent {

    public TransactionsSent(String accountId, Integer amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public TransactionsSent(String account, String amount) {
    }

    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("amount")
    @Expose
    private Integer amount;

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
}
