package com.nimtego.volt.view;

import android.app.AlarmManager;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nimtego.volt.R;
import com.nimtego.volt.model.UserData;
import com.nimtego.volt.presenter.Presenter;
import com.nimtego.volt.presenter.UserLogPresenter;

public class UserLogActivity extends AppCompatActivity implements UserLogInterface{
    private Presenter mPresenter;
    private EditText mLogIn;
    private EditText mPassword;
    private AlertDialog.Builder mAlert;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);
        init();
    }

    private void init() {
        mPresenter = new UserLogPresenter();
        mPresenter.attachView(this);

        findViewById(R.id.sing_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClick(v);
            }
        });
        findViewById(R.id.sing_up_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClick(v);
            }
        });
        mLogIn = (EditText) findViewById(R.id.logIn_edit_text);
        mPassword = (EditText) findViewById(R.id.password_edit_text);
        mContext = UserLogActivity.this;
        mAlert = new  AlertDialog.Builder(mContext);
    }


    @Override
    public void toast(String message) {
        Toast.makeText(mContext, message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void alarm(String message) {
       // mAlert.setTitle();  // заголовок
        mAlert.setMessage(message); // сообщение
        mAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                mPresenter.onClick(findViewById(R.id.sing_up_button));
            }
        });
        mAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                mLogIn.clearComposingText();
                mPassword.clearComposingText();
            }
        });
/*        mAlert.setCancelable(true);
        mAlert.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(mContext, "!!!!!",
                        Toast.LENGTH_LONG).show();
            }
        });*/
        mAlert.show();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public UserData getUserData() {
        UserData userData = new UserData();
        userData.setLogIn(mLogIn.getText().toString());
        userData.setPassword(mPassword.getText().toString());
        return userData;
    }
}
