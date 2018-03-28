package com.nimtego.volt.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.nimtego.volt.R;
import com.nimtego.volt.model.User;
import com.nimtego.volt.model.UserApi;
import com.nimtego.volt.model.UserData;
import com.nimtego.volt.model.UserLoginException;
import com.nimtego.volt.model.UsersModel;
import com.nimtego.volt.view.SheetAmountsWork;
import com.nimtego.volt.view.UserLogView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nimtego_loc on 20.03.2018.
 */

public class UserLogPresenter extends AbstractBasePresenter <UserLogView> {
    private UsersModel mUserModel;
    private UserApi mUserApi;

    public UserLogPresenter() {
        mUserModel = new UsersModel("https://rawgit.com/startandroid/data/master/messages/");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sing_in_button:
                singIn();
                break;
            case R.id.sing_up_button:
                singUp();
                break;
            default:
                Log.v("Button", "default in onClick method!!!");
        }
    }

    @Override
    public void viewIsReady() {
        // TODO: 28.03.2018
    }

    private void singUp() {
        UserData checkedUser = commonView.getUserData();
        String logIn = checkedUser.getLogIn();
        String password = checkedUser.getPassword();
        if (logIn.isEmpty() || password.isEmpty())
            commonView.toast("" +(logIn.isEmpty() ? "Log in " : "password ") +"cannot be empty.");
        else {
            if (mUserModel.isBusyName(logIn)) {
                commonView.toast("Login is busy");
            }
            else {
                User user = new User();
                user.setLogIn(logIn);
                user.setPassword(password);
                mUserModel.addUser(user);
                commonView.toast("User " +logIn +" add" );
                intent();
            }
        }
    }


    private void singIn() {
        UserData checkedUser = commonView.getUserData();
        String logIn = checkedUser.getLogIn();
        String password = checkedUser.getPassword();
        if (logIn.isEmpty() || password.isEmpty())
            commonView.toast("" +(logIn.isEmpty() ? "Log in " : "password ") +"cannot be empty.");
        else {
            try {
                User user = mUserModel.getUser(logIn, password);
                if (user == null) {
                    commonView.alarm("User not find\n Create user?");
                }
                else {
                    commonView.toast("User " +user.getLogIn() +"sing in");
                }
            } catch (UserLoginException e) {
                commonView.toast(e.getMessage());
            }

        }
    }

    private void intent() {
        Intent intent = new Intent((Context) commonView, SheetAmountsWork.class);
        ((AppCompatActivity)commonView).startActivity(intent);

    }
}
