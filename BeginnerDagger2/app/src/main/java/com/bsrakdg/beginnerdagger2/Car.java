package com.bsrakdg.beginnerdagger2;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    // The order : Constructor injection -> Field injection -> Method injection
    private static final String TAG = "Car";

    @Inject Engine engine; // Field injection
    private Wheels wheels;

    @Inject
    public Car(Wheels wheels) { // Constructor injection
        this.wheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "drive: driving...");
    }

    @Inject
    public void enableRemote(Remote remote) { // Method injection
        remote.setListener(this);
    }
}
