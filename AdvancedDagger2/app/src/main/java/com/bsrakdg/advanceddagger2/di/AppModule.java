package com.bsrakdg.advanceddagger2.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static boolean getApp(Application application) {
        // Builder application(Application application) on AppComponent
        return application == null;
    }

    @Provides
    static String someString() {
        return "Test string";
    }
}
