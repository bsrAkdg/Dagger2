package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.MainActivity;
import com.bsrakdg.beginnerdagger2.car.Car;

import dagger.Component;

@Component(modules = {WheelsModule.class, DiesellEngineModule.class})
public interface CarComponent { // The Injector
    Car getCar();

    void inject(MainActivity mainActivity);
}
