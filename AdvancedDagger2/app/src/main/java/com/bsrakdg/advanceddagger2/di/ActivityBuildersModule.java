package com.bsrakdg.advanceddagger2.di;

import com.bsrakdg.advanceddagger2.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector // needed abstract
    abstract AuthActivity contributeAuthActivity(); // AuthActivity wait data from AppComponent

}
