package com.bsrakdg.beginnerdagger2;

import android.app.Application;

public class ExampleApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.factory().create(new DriverModule("Okan"));
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
