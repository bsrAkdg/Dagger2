package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.car.Engine;
import com.bsrakdg.beginnerdagger2.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine petrolEngine);
}
