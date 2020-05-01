package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.AppComponent;
import com.bsrakdg.beginnerdagger2.DriverModule;
import com.bsrakdg.beginnerdagger2.MainActivity;
import com.bsrakdg.beginnerdagger2.PerActivity;
import com.bsrakdg.beginnerdagger2.car.Car;
import com.bsrakdg.beginnerdagger2.car.Driver;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower); // 500

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        Builder appComponent(AppComponent appComponent);

        CarComponent build();
    }
}
