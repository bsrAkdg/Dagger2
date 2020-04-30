package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.car.DieselEngine;
import com.bsrakdg.beginnerdagger2.car.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {

    private int horsePower; // get run time

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    int provideHorsePower() {
        return horsePower;
    }

    @Provides
    Engine provideEngine(DieselEngine engine) {
        return engine;
    }
}
