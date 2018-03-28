package com.nimtego.volt.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nimtego_loc on 27.03.2018.
 */

public interface UserApi {
    @GET("getUsers.json")
    Call<List<User>> getUsers();
    @GET("getUser.json")
    Call<User> getUser(String name, String password);
}
