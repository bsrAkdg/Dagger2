package com.bsrakdg.advanceddagger2;

import com.bsrakdg.advanceddagger2.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    // BaseApplication : client, AppComponent : server
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        // return app component
        return DaggerAppComponent.builder().application(this).build();
    }
}
