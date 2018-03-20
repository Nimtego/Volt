package com.nimtego.volt.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nimtego.volt.R;
import com.nimtego.volt.presenter.Presenter;
import com.nimtego.volt.presenter.UserLogPresenter;

public class UserLogActivity extends AppCompatActivity implements UserLogInterface{
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);
        init();
    }

    private void init() {
        mPresenter = new UserLogPresenter();
    }

    @Override
    public String login() {
        return null;
    }

    @Override
    public String password() {
        return null;
    }

    @Override
    public void toast(String message) {

    }

    @Override
    public void alarm(String message) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
