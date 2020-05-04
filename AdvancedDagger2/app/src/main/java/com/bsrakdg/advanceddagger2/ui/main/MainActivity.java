package com.bsrakdg.advanceddagger2.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.bsrakdg.advanceddagger2.BaseActivity;
import com.bsrakdg.advanceddagger2.R;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: starting");
    }
}
