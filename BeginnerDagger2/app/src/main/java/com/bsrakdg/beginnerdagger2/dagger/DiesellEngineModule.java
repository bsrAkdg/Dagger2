package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.car.DieselEngine;
import com.bsrakdg.beginnerdagger2.car.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DiesellEngineModule {

    /*@Provides
    Engine provideEngine(DieselEngine engine) {
        return engine;
    }*/

    @Binds
    abstract Engine provideEngine(DieselEngine petrolEngine);
}
