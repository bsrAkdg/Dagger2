package com.bsrakdg.beginnerdagger2.car;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    // The order : Constructor injection -> Field injection -> Method injection
    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;

    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        engine.start();
        Log.d(TAG, "drive: driving...");
    }

    @Inject
    public void enableRemote(Remote remote) { // Method injection
        remote.setListener(this);
    }
}
