package com.bsrakdg.advanceddagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.bsrakdg.advanceddagger2.SessionManager;
import com.bsrakdg.advanceddagger2.models.User;
import com.bsrakdg.advanceddagger2.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;
    private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();
    private SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;
        Log.d(TAG, "AuthViewModel: viewmodel is working");
    }

    private LiveData<AuthResource<User>> queryUserId(int userId) {
        return LiveDataReactiveStreams
                .fromPublisher(authApi.getUser(userId)
                        .subscribeOn(Schedulers.io())
                        .onErrorReturn(new Function<Throwable, User>() {
                            @Override
                            public User apply(Throwable throwable) throws Exception {
                                User errorUser = new User();
                                errorUser.setId(-1);
                                return errorUser;
                            }
                        })
                        .map(new Function<User, AuthResource<User>>() {
                            @Override
                            public AuthResource<User> apply(User user) throws Exception {
                                if (user.getId() == -1) {
                                    return AuthResource.error("Could not authenticate", null);
                                }
                                return AuthResource.authenticated(user);
                            }
                        }));
    }

    public void authenticateWithId(int userId) {
        Log.d(TAG, "authenticateWithId: attempting to login...");
        sessionManager.authenticateWithId(queryUserId(userId));
    }

    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }
}
