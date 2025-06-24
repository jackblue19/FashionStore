package com.example.fashionstore.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fashionstore.domain.model.User;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "fashionstore_pref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_FULLNAME = "fullname";

    private static SharedPrefManager mInstance;
    private final SharedPreferences sharedPreferences;

    private SharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, user.getUserName());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PASSWORD, user.getPassword());
        editor.putString(KEY_FULLNAME, user.getFullName());
        editor.apply();
    }

    public User getUser() {
        return new User(
                sharedPreferences.getString(KEY_USERNAME, ""),
                sharedPreferences.getString(KEY_EMAIL, ""),
                sharedPreferences.getString(KEY_PASSWORD, ""),
                sharedPreferences.getString(KEY_FULLNAME, "")
        );
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
