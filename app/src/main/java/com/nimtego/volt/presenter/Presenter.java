package com.nimtego.volt.presenter;

import android.view.View;
import com.nimtego.volt.view.CommonView;

/**
 * Created by nimtego_loc on 18.03.2018.
 */

public interface Presenter<T extends CommonView> {
    void onClick(View view);
    void attachView(T commonView);
    void detachView();
    void viewIsReady();
    void destroy();
}
