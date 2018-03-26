package com.nimtego.volt.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.nimtego.volt.R;
import com.nimtego.volt.model.User;
import com.nimtego.volt.model.UserData;
import com.nimtego.volt.model.UserLoginException;
import com.nimtego.volt.model.UsersModel;
import com.nimtego.volt.view.AmountsActivity;
import com.nimtego.volt.view.SheetAmountsWork;
import com.nimtego.volt.view.UserLogInterface;
import com.nimtego.volt.view.VoltMainActivity;

/**
 * Created by nimtego_loc on 20.03.2018.
 */

public class UserLogPresenter implements Presenter {
    private UserLogInterface mUserLogInterface;
    private UsersModel mUserModel;

    public UserLogPresenter() {
        mUserModel = new UsersModel();
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

    private void singUp() {
        UserData checkedUser = mUserLogInterface.getUserData();
        String logIn = checkedUser.getLogIn();
        String password = checkedUser.getPassword();
        if (logIn.isEmpty() || password.isEmpty())
            mUserLogInterface.toast("" +(logIn.isEmpty() ? "Log in " : "password ") +"cannot be empty.");
        else {
            if (mUserModel.isBusyName(logIn)) {
                mUserLogInterface.toast("Login is busy");
            }
            else {
                User user = new User();
                user.setLogIn(logIn);
                user.setPassword(password);
                mUserModel.addUser(user);
                mUserLogInterface.toast("User " +logIn +" add" );
                intent();
            }
        }
    }


    private void singIn() {
        UserData checkedUser = mUserLogInterface.getUserData();
        String logIn = checkedUser.getLogIn();
        String password = checkedUser.getPassword();
        if (logIn.isEmpty() || password.isEmpty())
            mUserLogInterface.toast("" +(logIn.isEmpty() ? "Log in " : "password ") +"cannot be empty.");
        else {
            try {
                User user = mUserModel.getUser(logIn, password);
                if (user == null) {
                    mUserLogInterface.alarm("User not find\n Create user?");
                }
                else {
                    mUserLogInterface.toast("User " +user.getLogIn() +"sing in");
                }
            } catch (UserLoginException e) {
                mUserLogInterface.toast(e.getMessage());
            }

        }
    }

    @Override
    public void attachView(AmountsActivity amountsActivity) {
        if (amountsActivity instanceof UserLogInterface)
            mUserLogInterface = (UserLogInterface) amountsActivity;
    }

    @Override
    public void detachView() {
        mUserLogInterface = null;
    }

    private void intent() {
        Intent intent = new Intent((Context) mUserLogInterface, SheetAmountsWork.class);
        ((AppCompatActivity)mUserLogInterface).startActivity(intent);

    }
}
