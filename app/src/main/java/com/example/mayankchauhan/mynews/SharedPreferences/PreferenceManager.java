package com.example.mayankchauhan.mynews.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mayankchauhan.mynews.Constant.Constants;

/**
 * Created by mayankchauhan on 16/04/17.
 */

public class PreferenceManager {

    private Context context;
    private SharedPreferences preferences;


    public PreferenceManager(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(Constants.STATE, Context.MODE_PRIVATE);
    }

    public void addValue(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getValue(String key)
    {
        return preferences.getBoolean(key, Constants.FALSE);
    }
}
