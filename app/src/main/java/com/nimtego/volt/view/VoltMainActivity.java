package com.nimtego.volt.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nimtego.volt.R;
import com.nimtego.volt.presenter.Presenter;
import com.nimtego.volt.presenter.VoltPresenter;

public class VoltMainActivity extends AppCompatActivity implements VoltView {
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volt_main);
        init();

    }

    private void init() {
        mPresenter = new VoltPresenter();
        mPresenter.attachView(this); // TODO: 28.03.2018
        setCurrent("0");
        setPower("0");
        setVoltage("0");
    }

    public void setVoltage(String text) {
        ((EditText)findViewById(R.id.voltage_editText)).setText(text);
    }

    public void setCurrent(String text) {
        ((EditText)findViewById(R.id.current_editText)).setText(text);
    }

    public void setPower(String text) {
        ((EditText)findViewById(R.id.power_editText)).setText(text);
    }

    @Override
    public View getVoltage() {
        return findViewById(R.id.voltage_editText);
    }

    @Override
    public View getCurrent() {
        return findViewById(R.id.current_editText);
    }

    @Override
    public View getPower() {
        return findViewById(R.id.power_editText);
    }

    @Override
    public void setResult(String result) {
        EditText editText = (EditText) findViewById(R.id.result_editText);
        editText.setText(result);
    }

    @Override
    public void toast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void alarm(String message) {
        // TODO: 20.03.2018
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
    @Override
    public void onClick(View view) {
        mPresenter.onClick(view);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.detachView();
    }
}
