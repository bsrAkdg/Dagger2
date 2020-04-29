package com.bsrakdg.beginnerdagger2;

import dagger.Component;

@Component(modules = WheelsModule.class)
public interface CarComponent { // The Injector
    Car getCar();

    void inject(MainActivity mainActivity);
}
