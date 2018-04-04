package com.nimtego.volt.model;

import android.content.SharedPreferences;

import java.util.List;

public class UserModelLocal implements UserModelProvider {
    private SharedPreferences mSharedPreferences;
    private List<User> mUserList;

    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
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
