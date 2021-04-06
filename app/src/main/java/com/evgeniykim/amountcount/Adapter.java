package com.evgeniykim.amountcount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evgeniykim.amountcount.data.model.Transactions;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Transactions> dataList;
    private Context mContext;
    int amount;
    String amountStr = String.valueOf(amount);

    public Adapter(List<Transactions> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView accountId, transactionId, amountTXT;


        ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

//            accountId = mView.findViewById(R.id.account_id_list);
            amountTXT = mView.findViewById(R.id.amount_list);
            transactionId = mView.findViewById(R.id.transaction_id_list);


        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        holder.accountId.setText(dataList.get(position).getAccountId());
        holder.amountTXT.setText("Transferred $" + amountStr.replaceAll("(^|[^0-9])0+", "") + dataList.get(position).getAmount() + " from account");
        holder.transactionId.setText(dataList.get(position).getTransactionId());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



}


