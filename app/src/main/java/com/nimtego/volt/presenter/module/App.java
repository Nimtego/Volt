package com.nimtego.volt.presenter.module;

import android.annotation.SuppressLint;
import android.app.Application;

@SuppressLint("Registered")
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
