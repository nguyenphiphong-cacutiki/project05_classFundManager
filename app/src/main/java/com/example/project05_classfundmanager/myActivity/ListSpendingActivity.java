package com.example.project05_classfundmanager.myActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project05_classfundmanager.R;
import com.example.project05_classfundmanager.model.ContentOfPaid;
import com.example.project05_classfundmanager.myAdapter.ListSpendingAdapter;
import com.example.project05_classfundmanager.myDatabase.FundDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListSpendingActivity extends AppCompatActivity {
private RecyclerView rcvList;
private TextView tvBackHome, tvMoneyCut;
private FundDatabase database;
private ListSpendingAdapter adapter;
private List<ContentOfPaid> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_spending);
        mappingAndInitializeVariable();
        loadDataForRecycleView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvList.setLayoutManager(linearLayoutManager);
        adapter.setData(list);
        rcvList.setAdapter(adapter);

        // load money
        Cursor dataSumMoney = database.getData("SELECT SUM(money) FROM ContentOfMoneyToBePaid");
        Cursor dataCutMoney = database.getData("SELECT SUM(money) FROM ContentOfMoneyPaid");
        if(dataCutMoney.moveToNext() && dataSumMoney.moveToNext()){
            int cut =(int) (dataSumMoney.getDouble(0) - dataCutMoney.getDouble(0));
            tvMoneyCut.setText("Số tiền còn lại là: "+ cut);
        }

    }
    private void mappingAndInitializeVariable(){
        rcvList = findViewById(R.id.rcvListSpending);
        tvBackHome = findViewById(R.id.tvHomeListSpending);
        tvMoneyCut = findViewById(R.id.tvMoneyCutListSpending);

        // initialize variable
        database = new FundDatabase(this);
        adapter = new ListSpendingAdapter(this);
        list = new ArrayList<>();
    }
    public void loadDataForRecycleView(){
        list.clear();
        Cursor data = database.getData("SELECT * FROM ContentOfMoneyPaid");
        while(data.moveToNext()){
            list.add(new ContentOfPaid(data.getInt(0), data.getString(1), data.getDouble(2),
                    data.getString(3), data.getString(4)));
        }

    }
}