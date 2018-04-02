package com.nimtego.volt.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nimtego.volt.R;

public class MainMenuActivity extends AppCompatActivity implements CommonView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public void toast(String message) {

    }

    @Override
    public void alarm(String message) {

    }

    @Override
    public void onClick(View view) {

    }
}
