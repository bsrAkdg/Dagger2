package com.bsrakdg.advanceddagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.bsrakdg.advanceddagger2.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;

        Log.d(TAG, "AuthViewModel: viewmodel is working");

        if (authApi == null) {
            Log.d(TAG, "AuthViewModel: authApi is NULL");
        } else {
            Log.d(TAG, "AuthViewModel: authApi is NOT NULL");
        }
    }
}
