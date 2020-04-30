package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.car.DieselEngine;
import com.bsrakdg.beginnerdagger2.car.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public class DiesellEngineModule {

    private int horsePower; // get run time

    public DiesellEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    Engine provideEngine() {
        return new DieselEngine(horsePower);
    }
}
