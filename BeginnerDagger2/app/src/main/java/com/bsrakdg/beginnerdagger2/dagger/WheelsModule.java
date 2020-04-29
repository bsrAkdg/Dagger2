package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.car.Rims;
import com.bsrakdg.beginnerdagger2.car.Tires;
import com.bsrakdg.beginnerdagger2.car.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {

    // Modules add objects to the dependency graph/ provides methods
    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
