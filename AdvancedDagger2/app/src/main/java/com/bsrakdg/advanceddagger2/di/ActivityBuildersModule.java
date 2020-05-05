package com.bsrakdg.advanceddagger2.di;

import com.bsrakdg.advanceddagger2.di.auth.AuthModule;
import com.bsrakdg.advanceddagger2.di.auth.AuthViewModelsModule;
import com.bsrakdg.advanceddagger2.di.main.MainFragmentBuildersModule;
import com.bsrakdg.advanceddagger2.ui.auth.AuthActivity;
import com.bsrakdg.advanceddagger2.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity(); // AuthActivity wait data from AppComponent

    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();

}
