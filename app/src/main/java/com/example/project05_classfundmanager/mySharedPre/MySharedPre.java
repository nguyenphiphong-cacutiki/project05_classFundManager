package com.example.project05_classfundmanager.mySharedPre;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPre {
    private SharedPreferences sharedPreferences;
    private Context context;

    // default value
    private final String NAME_SHARED_PRE = "NAME_SHARED_PRE";
    private final String NAME_ADD_CLASS = "NAME_ADD_CLASS";
    private final String NAME_ADD_NAME = "NAME_ADD_NAME";
    private final String NAME_ADD_USER = "NAME_ADD_USER";
    public static String NULL_DATA = "NULL_DATA";



    public MySharedPre(Context context){
        this.context = context;
    }
    public void addUser(String user){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_ADD_USER, user);
        editor.apply();
    }
    public void addPass(String user, String pass){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(user, pass);
        editor.apply();
    }
    public void addName(String user, String name){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(user+NAME_ADD_NAME, name);
        editor.apply();
    }
    public void addClass(String user, String yourClass){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(user + NAME_ADD_CLASS, yourClass);
        editor.apply();
    }
    public String getUser(){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(NAME_ADD_USER, NULL_DATA);
    }
    public String getPass(String user){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(user, NULL_DATA);
    }
    public String getName(String user){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(user+NAME_ADD_NAME, NULL_DATA);
    }
    public String getYourClass(String user){
        sharedPreferences = context.getSharedPreferences(NAME_SHARED_PRE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(user + NAME_ADD_CLASS, NULL_DATA);
    }
}
