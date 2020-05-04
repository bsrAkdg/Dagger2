package com.bsrakdg.advanceddagger2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bsrakdg.advanceddagger2.models.User;
import com.bsrakdg.advanceddagger2.ui.auth.AuthActivity;
import com.bsrakdg.advanceddagger2.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {
    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void navLoginScreen() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }

    private void subscribeObservers() {
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING:
                            break;
                        case ERROR:
                            Log.d(TAG, "onChanged: ERROR : " + userAuthResource.message);
                            break;
                        case NOT_AUTHENTICATED:
                            navLoginScreen(); // trigger when SessionManager logout() called
                            break;
                        case AUTHENTICATED:
                            Log.d(TAG, "onChanged: LOGIN SUCCESS : " + userAuthResource.data
                                    .getEmail());
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }
}
