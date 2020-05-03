package com.bsrakdg.advanceddagger2.di;

import androidx.lifecycle.ViewModelProvider;

import com.bsrakdg.advanceddagger2.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

    // Below code the same with bindViewModelFactory
    // but bindViewModelFactory is more efficient way to provide a dependency
    /*@Provides
    static ViewModelProvider.Factory provideFactory(ViewModelProviderFactory modelProviderFactory) {
        return modelProviderFactory;
    }*/

}
