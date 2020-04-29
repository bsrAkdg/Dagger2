package com.bsrakdg.beginnerdagger2;

import dagger.Component;

@Component
public interface CarComponent { // The Injector
    Car getCar();
}
