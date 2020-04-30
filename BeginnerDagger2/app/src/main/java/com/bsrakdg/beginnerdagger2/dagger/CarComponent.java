package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.MainActivity;
import com.bsrakdg.beginnerdagger2.car.Car;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent { // The Injector
    Car getCar();

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower); // 500

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        CarComponent build();
    }
}
