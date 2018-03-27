package com.nimtego.volt.model;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by nimtego_loc on 27.03.2018.
 */

public interface ServerApi {
    @GET("getUser.json")
    User getUser(long id);
    @GET("getUser.json")
    User getUser(String name);
    @GET("getUsers.json")
    List<User> getUsers();
}
