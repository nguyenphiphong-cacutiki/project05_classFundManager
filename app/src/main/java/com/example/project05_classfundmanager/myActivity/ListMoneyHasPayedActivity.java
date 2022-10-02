package com.example.project05_classfundmanager.myActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.project05_classfundmanager.R;
import com.example.project05_classfundmanager.model.ContentOfMoneyToBePay;
import com.example.project05_classfundmanager.myAdapter.ListMoneyHasPayAdapter;
import com.example.project05_classfundmanager.myDatabase.FundDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListMoneyHasPayedActivity extends AppCompatActivity {
    private ImageView imgAdd, imgBack;
    private RecyclerView rcvList;
    private FundDatabase database;
    private List<ContentOfMoneyToBePay> listMoney;
    private ListMoneyHasPayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_money_has_payed);
        mappingAndInitializeVariable();
        loadData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvList.setLayoutManager(linearLayoutManager);
        adapter.setData(listMoney);
        rcvList.setAdapter(adapter);
    }

    private void mappingAndInitializeVariable(){
//        imgAdd = findViewById(R.id.imgAddListMoneyHasToPayed);
        imgBack = findViewById(R.id.imgBackHomeListMoneyHasToPayed);
        rcvList = findViewById(R.id.rcvListMoneyHasToPayed);

        // initialize variable
        adapter = new ListMoneyHasPayAdapter(this);
        database = new FundDatabase(this);
        listMoney = new ArrayList<>();
    }
    private void loadData(){
        listMoney.clear();
        Cursor data = database.getData("SELECT * FROM ContentOfMoneyToBePaid");
        while(data.moveToNext()){
            listMoney.add(new ContentOfMoneyToBePay(data.getInt(0), data.getString(1),
                    data.getDouble(2), data.getString(3), data.getString(4)));
        }
    }
}