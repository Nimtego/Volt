package com.nimtego.volt.view;

import android.view.View;

import com.nimtego.volt.presenter.Presenter;

/**
 * Created by nimtego_loc on 18.03.2018.
 */

public interface VoltActivity extends AmountsActivity{
    void putPresenter(Presenter presenter);
    View getVoltage();
    View getCurrent();
    View getPower();
    void setResult(String result);
}
