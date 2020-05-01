package com.bsrakdg.beginnerdagger2;


import com.bsrakdg.beginnerdagger2.dagger.CarComponent;
import com.bsrakdg.beginnerdagger2.dagger.DieselEngineModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {
    CarComponent getCarComponent(DieselEngineModule dieselEngineModule);
}
