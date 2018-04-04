package com.nimtego.volt.model;

public interface UserModelProvider {
    User getUser(String name);
    boolean addUser(User user);
    boolean removeUser(User user);
    boolean isBusyName(String name);
}
