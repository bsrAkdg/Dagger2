package com.bsrakdg.beginnerdagger2.dagger;

import com.bsrakdg.beginnerdagger2.MainActivity;
import com.bsrakdg.beginnerdagger2.PerActivity;
import com.bsrakdg.beginnerdagger2.car.Car;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {
    Car getCar();

    void inject(MainActivity mainActivity);

    //@Component.Builder
    //interface Builder {
    //
    //    @BindsInstance
    //    Builder horsePower(@Named("horse power") int horsePower); // 500
    //
    //    @BindsInstance
    //    Builder engineCapacity(@Named("engine capacity") int engineCapacity);
    //
    //    Builder appComponent(AppComponent appComponent);
    //
    //    CarComponent build();
    //}
}
