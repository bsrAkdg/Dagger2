package com.bsrakdg.advanceddagger2;

import com.bsrakdg.advanceddagger2.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    /** BaseApplication extendes from DaggerApplication,
     * because it allows injecting to AppComponent
     */

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
