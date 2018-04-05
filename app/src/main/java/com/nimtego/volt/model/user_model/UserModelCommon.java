package com.nimtego.volt.model.user_model;

import com.nimtego.volt.model.User;

import java.util.ArrayList;
import java.util.List;

public abstract class UserModelCommon implements UserModelProvider {
    protected List<User> mUserList;

    public UserModelCommon() {
        mUserList = new ArrayList<>();
    }
}
