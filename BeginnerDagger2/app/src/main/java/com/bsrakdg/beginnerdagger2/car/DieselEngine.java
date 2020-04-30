package com.bsrakdg.beginnerdagger2.car;

import android.util.Log;

public class DieselEngine implements Engine {
    private static final String TAG = "DieselEngine";

    private int horsePower;

    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: Diesel Engine started. Horse power : " + horsePower);
    }
}
