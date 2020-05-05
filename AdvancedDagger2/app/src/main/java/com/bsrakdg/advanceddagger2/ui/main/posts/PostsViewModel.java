package com.bsrakdg.advanceddagger2.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.bsrakdg.advanceddagger2.SessionManager;
import com.bsrakdg.advanceddagger2.network.main.MainApi;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";

    private final SessionManager sessionManager;
    private final MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
        Log.d(TAG, "PostViewModel: view model is ready...");
    }
}
