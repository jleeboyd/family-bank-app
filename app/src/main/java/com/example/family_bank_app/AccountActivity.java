package com.example.family_bank_app;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountActivity extends AppCompatActivity {
    RecyclerView transactionRecyclerView;
    MyTransactionAdapter myTransactionAdapter;
    String note[], amount[], currentBal[], names[], balances[];
    Date date[];
    Date d;
    TextView accountName, accountBal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        note = new String[]{"Cheese", "More Cheese", "PepperJack"};
        amount = new String[]{"5.00", "6.00", "7.00"};
        currentBal = new String[]{"20.00", "14.00", "7.00" };
        names = new String[]{"Jerry Law", "Mary Stringer"};
        balances = new String[]{"413.20$", "876.45$"};

        accountName = findViewById(R.id.NameOfAccount);
        accountBal = findViewById(R.id.balance);

        int pos = getIntent().getIntExtra("POSITION", 0);

        accountName.setText(names[pos]);
        accountBal.setText(balances[pos]);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            d = sdf.parse("20201018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = new Date[]{d, d, d};

        transactionRecyclerView = findViewById(R.id.TransactionRecycler);

        myTransactionAdapter = new MyTransactionAdapter(this, note, amount, currentBal, date );
        transactionRecyclerView.setAdapter(myTransactionAdapter);
        transactionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myTransactionAdapter.notifyDataSetChanged();


    }


}