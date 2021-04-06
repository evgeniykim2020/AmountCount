package com.evgeniykim.amountcount.data.remote;

import com.evgeniykim.amountcount.data.model.Transactions;
import com.evgeniykim.amountcount.data.model.TransactionsSent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Service {

    @GET("/api/transaction-management/transactions")
    Call<List<Transactions>> getData();

    @POST("/transaction-management/transaction")
    Call<TransactionsSent> sendData(@Body TransactionsSent transactionsSent);



//    @GET("/api/transaction-management/transactions")
//    Call<Transactions> getAnswers(@Query("tagged") String tags);
}
