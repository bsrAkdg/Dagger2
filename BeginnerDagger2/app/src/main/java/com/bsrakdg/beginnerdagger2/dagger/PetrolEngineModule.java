package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.car.Engine;
import com.bsrakdg.beginnerdagger2.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    /*@Provides
    Engine provideEngine(PetrolEngine engine) {
        return engine;
    }*/

    @Binds
    abstract Engine provideEngine(PetrolEngine petrolEngine);
}
