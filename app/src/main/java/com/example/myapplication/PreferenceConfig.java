package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PreferenceConfig {

    private static final String LIST_KEY = "list_key";

    public static void writeListInPreference(Context context, ArrayList<Item> list) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<Item> readListFromPreference(Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = preferences.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Item>>() {}.getType();
        ArrayList<Item> list = gson.fromJson(jsonString, type);
        return list;
    }

    public static void deleteItemFromPreference(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String item = preferences.getString(LIST_KEY, "");

        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("LIST_KEY");
        editor.commit();
        editor.apply();
    }
}
