package com.bsrakdg.advanceddagger2.di;

import android.app.Application;

import com.bsrakdg.advanceddagger2.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/** There is a client(BaseApplication)-server(AppComponent) relationship
 *  between AppComponent and BaseApplication and this provided by AndroidInjector
 *  If AppComponent dies all dependencies die
 * */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        ViewModelFactoryModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
