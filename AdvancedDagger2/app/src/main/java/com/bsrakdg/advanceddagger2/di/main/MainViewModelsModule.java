package com.bsrakdg.advanceddagger2.di.main;

import androidx.lifecycle.ViewModel;

import com.bsrakdg.advanceddagger2.di.ViewModelKey;
import com.bsrakdg.advanceddagger2.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel profileViewModel);
}
