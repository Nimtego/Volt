package com.nimtego.volt.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;

import com.nimtego.volt.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class UsersModel {
    private UserApi mUserApi;
    private Retrofit mRetrofit;
    private List<User> mUserList;
/*    public UsersModel(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
    */
    public UsersModel(String url) {
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

    public User getUser(String logIn, String password) throws UserLoginException {
        User user = null;
        for (User us: mUserList) {
            if (us.getLogIn().equals(logIn)) {
                if (us.getPassword().equals(password)) {
                    user = us;
                    break;
                }
                throw new UserLoginException("Wrong password");
            }
        }
        return user;
    }

    public boolean isBusyName(String login) {
        String log;
        for (User us: mUserList) {
            if (login.equals(us.getLogIn()))
                return true;
        }
        return false;
    }

    public void addUser(User user) {
        user.setId(UUID.randomUUID().getLeastSignificantBits());
        mUserList.add(user);
    }
}