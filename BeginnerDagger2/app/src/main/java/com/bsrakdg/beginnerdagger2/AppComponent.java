package com.bsrakdg.beginnerdagger2;


import com.bsrakdg.beginnerdagger2.car.Driver;
import com.bsrakdg.beginnerdagger2.car.Wheels;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {
    Driver getDrive();
}
