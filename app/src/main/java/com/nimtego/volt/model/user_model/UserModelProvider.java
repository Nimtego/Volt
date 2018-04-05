package com.nimtego.volt.model.user_model;

import com.nimtego.volt.model.User;

public interface UserModelProvider {
    User getUser(String name);
    boolean addUser(User user);
    boolean removeUser(User user);
    boolean isBusyName(String name);
}
