package com.nimtego.volt.model;

/**
 * Created by nimtego_loc on 20.03.2018.
 */

public class User {
    private long id;
    private String logIn;
    private String password;
    private String name = "empty";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
