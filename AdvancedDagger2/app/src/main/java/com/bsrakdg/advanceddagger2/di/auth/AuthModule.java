package com.bsrakdg.advanceddagger2.di.auth;

import com.bsrakdg.advanceddagger2.models.User;
import com.bsrakdg.advanceddagger2.network.auth.AuthApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

    @AuthScope
    @Provides
    @Named("auth_user")
    static User someUser() {
        return new User();
    }

}
