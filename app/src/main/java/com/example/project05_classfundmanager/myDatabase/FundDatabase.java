package com.example.project05_classfundmanager.myDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.project05_classfundmanager.model.ContentOfMoneyToBePay;
import com.example.project05_classfundmanager.model.ContentOfPaid;
import com.example.project05_classfundmanager.model.PersonHasPayed;

public class FundDatabase extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "sql.fundDatabase";

    public FundDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ContentOfMoneyToBePaid(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, money DOUBLE, date TEXT, note TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS  PersonHasPayed(id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER, name TEXT, date TEXT, note TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ContentOfMoneyPaid(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, money DUOBLE, date TEXT, note TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    // function insert
    public void insertContentOfMoneyToBePaid(ContentOfMoneyToBePay object){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO ContentOfMoneyToBePaid VALUES(null, '"+object.getName()+"', '"+object.getMoney()+"', '"+object.getDate()+"', '"+object.getNote()+"')");
    }
    public void insertPersonHasPayed(PersonHasPayed object){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO PersonHasPayed VALUES(null, '"+object.getType()+"', '"+object.getName()+"', '"+object.getDate()+"', '"+object.getNote()+"')");
    }
    public void insertSpending(ContentOfPaid object){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO ContentOfMoneyPaid VALUES(null, '"+object.getName()+"', '"+object.getMoney()+"', '"+object.getDate()+"', '"+object.getNote()+"')");
    }

    // function delete
    public void deleteContentOfMoneyToBePaid(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM ContentOfMoneyToBePaid WHERE id = '"+id+"'");
    }
    public Cursor getContentOfMoneyToBePaid(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String sql = "SELECT * FROM ContentOfMoneyToBePaid";
        return sqLiteDatabase.rawQuery(sql, null);
    }
    public Cursor getData(String sql){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }
}
