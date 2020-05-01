package com.bsrakdg.beginnerdagger2;


import com.bsrakdg.beginnerdagger2.dagger.CarComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {
    CarComponent.Factory getCarComponentFactory();

    @Component.Factory
    interface Factory {
        AppComponent create(DriverModule driverModule);
    }
}
