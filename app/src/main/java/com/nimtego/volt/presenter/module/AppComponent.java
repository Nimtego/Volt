package com.nimtego.volt.presenter.module;

import com.nimtego.volt.view.CommonView;
import com.nimtego.volt.view.UserLogActivity;

import dagger.Component;

@Component(modules = {PresenterModule.class})
public interface AppComponent {
    void injectsView(UserLogActivity commonView);
}
