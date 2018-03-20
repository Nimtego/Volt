package com.nimtego.volt.presenter;

import android.view.View;

import com.nimtego.volt.view.AmountsActivity;

/**
 * Created by nimtego_loc on 18.03.2018.
 */

public interface Presenter {
    void onClick(View view);
    void attachView(AmountsActivity amountsActivity);
    void detachView();
}
