package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.MainActivity;
import com.bsrakdg.beginnerdagger2.PerActivity;
import com.bsrakdg.beginnerdagger2.car.Car;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(MainActivity mainActivity);

    /*@Subcomponent.Builder  TODO Factory added
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower); // 500

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        CarComponent build();
    }*/

    @Subcomponent.Factory
    interface Factory {
        CarComponent create(@BindsInstance @Named("horse power") int horsePower,
                            @BindsInstance @Named("engine capacity") int engineCapacity);
    }
}
