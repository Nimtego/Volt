package com.nimtego.volt.presenter.module;

import com.nimtego.volt.presenter.Presenter;
import com.nimtego.volt.presenter.UserLogPresenter;
import com.nimtego.volt.presenter.VoltPresenter;
import com.nimtego.volt.view.UserLogView;
import com.nimtego.volt.view.VoltView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    Presenter<UserLogView> provideUserLog() {
        return new UserLogPresenter();
    }
    @Provides
    Presenter<VoltView> provideVolt() {
        return new VoltPresenter();
    }
}
