package com.example.family_bank_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;


public class MyTransactionAdapter extends RecyclerView.Adapter<MyTransactionAdapter.ViewHolder> {

    List<String> Note, Date;
    List<Double> Amount, CurBalance;
    Context context;
    CardView cardView;

    public MyTransactionAdapter(Context ct, List<String> s1, List<Double> s2, List<Double> s3, List<String> s4 ) {
        context = ct;
        Note = s1;
        Amount = s2;
        CurBalance = s3;
        Date= s4;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.transaction_card_layout, parent, false );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.text2.setText(valueOf(Amount.get(position)));
        holder.text5.setText(valueOf(Date.get(position)));
        holder.text3.setText(valueOf(Note.get(position)));
        holder.text4.setText(valueOf(CurBalance.get(position)));
    }

    @Override
    public int getItemCount() {
        if(Amount == null){return 0;}
        return Amount.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text1, text2, text3, text4, text5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.transactionDate);
            text2 = itemView.findViewById(R.id.transactionAmt);
            text3 = itemView.findViewById(R.id.transactionNote);
            text4 = itemView.findViewById(R.id.transactionCurrentBalance);
            text5 = itemView.findViewById(R.id.transactionActivityTime);
            cardView = itemView.findViewById(R.id.transactionCardView);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
                 goToTransactionActivity(position);
        }

        public void goToTransactionActivity(int position) {
            Intent intent = new Intent(context, TransactionActivity.class);

            intent.putExtra("POSITION", position);
            context.startActivity(intent);

        }
    }
}




