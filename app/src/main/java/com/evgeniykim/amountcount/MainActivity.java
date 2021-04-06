package com.evgeniykim.amountcount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evgeniykim.amountcount.data.model.Transactions;
import com.evgeniykim.amountcount.data.model.TransactionsSent;
import com.evgeniykim.amountcount.data.remote.ApiUtils;
import com.evgeniykim.amountcount.data.remote.RetrofitClient;
import com.evgeniykim.amountcount.data.remote.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private Service mService;
    ProgressDialog progressDialog;
    private EditText accountIdsent, amountSent;
    private Button submitBtn;
    private int amountSnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        accountIdsent = findViewById(R.id.input_id);
        amountSent = findViewById(R.id.input_amount);
        submitBtn = findViewById(R.id.submit);

        Service service = ApiUtils.getService();
        Call<List<Transactions>> call = service.getData();
        call.enqueue(new Callback<List<Transactions>>() {
            @Override
            public void onResponse(Call<List<Transactions>> call, Response<List<Transactions>> response) {

                generateDataList(response.body());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<Transactions>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Error on using API", Toast.LENGTH_SHORT).show();
            }
        });

        btnPressed();
    }

    private void generateDataList(List<Transactions> transactions) {
        mRecyclerView = findViewById(R.id.rv);
        mAdapter = new Adapter(transactions, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void btnPressed() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accoundID = accountIdsent.getText().toString();
                String amountstring = amountSent.getText().toString();
                amountstring = String.valueOf(amountSnt);

                if (accoundID.isEmpty() && amountstring.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                sendPost(accoundID, amountstring);
                accountIdsent.setText("");
                amountSent.setText("");
            }
        });
    }

    private void sendPost(String account, String amount) {

        TransactionsSent transactionsSent = new TransactionsSent(account, amount);
        Service service = ApiUtils.getService();
        Call<TransactionsSent> call = service.sendData(transactionsSent);
        call.enqueue(new Callback<TransactionsSent>() {
            @Override
            public void onResponse(Call<TransactionsSent> call, Response<TransactionsSent> response) {
                Toast.makeText(MainActivity.this, "Data added", Toast.LENGTH_SHORT).show();
                TransactionsSent transactionsSent1 = response.body();
            }

            @Override
            public void onFailure(Call<TransactionsSent> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Data adding failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}