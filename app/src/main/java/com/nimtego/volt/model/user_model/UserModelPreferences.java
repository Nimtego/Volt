package com.nimtego.volt.model.user_model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.nimtego.volt.model.User;

//Preferences save
public class UserModelPreferences extends UserModelCommon implements UserModelProvider {
    private SharedPreferences mSharedPreferences;

    public UserModelPreferences(SharedPreferences sp) {
        mSharedPreferences = sp;
    }
    @Override
    public User getUser(String name) {
        User user = new User();
        String password = mSharedPreferences.getString(name, "");
        user.setLogIn(name);
        user.setPassword(password);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        Editor editor = mSharedPreferences.edit();
        editor.putString(user.getLogIn(), user.getPassword());
        editor.commit();
        return true;
    }

    @Override
    public boolean removeUser(User user) {
        return false;
    }

    @Override
    public boolean isBusyName(String name) {
        return false;
    }
}
