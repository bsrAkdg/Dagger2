package com.bsrakdg.beginnerdagger2;

import com.bsrakdg.beginnerdagger2.car.Driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DriverModule {

    @Singleton
    @Provides
    static Driver provideDriver() {
        return new Driver();
    }
}
