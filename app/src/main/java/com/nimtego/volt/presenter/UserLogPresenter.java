package com.nimtego.volt.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nimtego.volt.R;
import com.nimtego.volt.model.User;
import com.nimtego.volt.model.UserApi;
import com.nimtego.volt.model.UserData;
import com.nimtego.volt.model.user_model.UserModelPreferences;
import com.nimtego.volt.model.user_model.UserModelProvider;
import com.nimtego.volt.util.Log;
import com.nimtego.volt.view.SheetAmountsWork;
import com.nimtego.volt.view.UserLogView;

import javax.inject.Inject;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by nimtego_loc on 20.03.2018.
 */

public class UserLogPresenter extends AbstractBasePresenter <UserLogView> {
    private UserModelProvider mUserModelProvider;
    private UserApi mUserApi;
    @Inject
    public UserLogPresenter() {
        Log.v("<<<< Constructor  >>>");
       //TODO mUserModel = new UsersModel("https://rawgit.com/startandroid/data/master/messages/");
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
                Log.v("default in onClick method!!!");
        }
    }

    @Override
    public void viewIsReady() {
        // TODO: 28.03.2018
    }

    private void singUp() {
        SharedPreferences sp = ((AppCompatActivity)commonView).getPreferences(MODE_PRIVATE);
        mUserModelProvider = new UserModelPreferences(sp);
        UserData checkedUser = commonView.getUserData();
        String logIn = checkedUser.getLogIn();
        String password = checkedUser.getPassword();
        if (logIn.isEmpty() || password.isEmpty())
            commonView.toast("" +(logIn.isEmpty() ? "Log in " : "password ") +"cannot be empty.");
        else {
            if (mUserModelProvider.isBusyName(logIn)) {
                commonView.toast("Login is busy");
            }
            else {
                User user = new User();
                user.setLogIn(logIn);
                user.setPassword(password);
                if (mUserModelProvider.addUser(user)) {
                    commonView.toast("User " + logIn + " add");
                    intent();
                }
            }
        }
    }


    private void singIn() {
        SharedPreferences sp = ((AppCompatActivity)commonView).getPreferences(MODE_PRIVATE);
        mUserModelProvider = new UserModelPreferences(sp);
        UserData checkedUser = commonView.getUserData();
        String logIn = checkedUser.getLogIn();
        String password = checkedUser.getPassword();
        if (logIn.isEmpty() || password.isEmpty())
            commonView.toast("" +(logIn.isEmpty() ? "Log in " : "password ") +"cannot be empty.");
        else {
                User user = mUserModelProvider.getUser(logIn); //todo check password user
                if (user == null) {
                    commonView.alarm("User not find\n Create user?");
                }
                else {
                    if (user.getPassword().equals(password)) {
                        commonView.toast("User " + user.getLogIn() + "sing in");
                    }
                    else {
                        commonView.toast("Incorrect password");
                    }
                }
        }
    }

    private void intent() {
        Intent intent = new Intent((Context) commonView, SheetAmountsWork.class);
        ((AppCompatActivity)commonView).startActivity(intent);

    }
}
