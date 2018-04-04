package com.nimtego.volt.view;

import android.app.Application;

import com.nimtego.volt.presenter.module.AppComponent;
import com.nimtego.volt.presenter.module.DaggerAppComponent;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
