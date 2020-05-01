package com.bsrakdg.beginnerdagger2.car;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class DieselEngine implements Engine {
    private static final String TAG = "DieselEngine";

    private int horsePower;

    @Inject
    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: Diesel Engine started. Horse power : " + horsePower);
    }
}
