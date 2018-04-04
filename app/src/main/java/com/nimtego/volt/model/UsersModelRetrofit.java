package com.nimtego.volt.model;

import com.nimtego.volt.util.Log;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nimtego_loc on 20.03.2018.
 */

public class UsersModelRetrofit implements UserModelProvider {
    private UserApi mUserApi;
    private Retrofit mRetrofit;
    private List<User> mUserList;
/*    public UsersModel(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
    */
    public UsersModelRetrofit(String url) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mUserApi = mRetrofit.create(UserApi.class);
        Call<List<User>> listCall = mUserApi.getUsers();
        listCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful())
                    mUserList = response.body();
                else
                    Log.v("!!!!!"); // TODO: 29.03.2018
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                // TODO: 29.03.2018  
            }
        });
    }
    @Override
    public User getUser(String name) {
        User user = null;
        for (User us: mUserList) {
            if (us.getLogIn().equals(name)) {
                user = us;
                break;
            }
        }
        return user;
    }
    @Override
    public boolean addUser(User user) {
        user.setId(UUID.randomUUID().getLeastSignificantBits());
        mUserList.add(user);
        return true;
    }

    @Override
    public boolean removeUser(User user) {
        return false;
    }

    @Override
    public boolean isBusyName(String name) {
        for (User us : mUserList) {
            if (us.getLogIn().equals(name)) {
                return true;
            }
        }
        return false;
    }
}