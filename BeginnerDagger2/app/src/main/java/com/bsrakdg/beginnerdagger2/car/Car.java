package com.bsrakdg.beginnerdagger2.car;

import android.util.Log;

import com.bsrakdg.beginnerdagger2.PerActivity;

import javax.inject.Inject;

@PerActivity
public class Car {
    // The order : Constructor injection -> Field injection -> Method injection
    private static final String TAG = "Car";

    private Driver driver;
    private Engine engine;
    private Wheels wheels;

    @Inject
    public Car(Driver driver, Engine engine, Wheels wheels) {
        this.driver = driver;
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        engine.start();
        Log.d(TAG, "driver : " + driver.name + " working to Car : " + this);
    }

    @Inject
    public void enableRemote(Remote remote) { // Method injection
        remote.setListener(this);
    }
}
