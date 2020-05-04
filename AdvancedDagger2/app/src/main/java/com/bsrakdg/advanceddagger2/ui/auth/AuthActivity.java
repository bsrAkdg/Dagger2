package com.bsrakdg.advanceddagger2.ui.auth;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bsrakdg.advanceddagger2.R;
import com.bsrakdg.advanceddagger2.models.User;
import com.bsrakdg.advanceddagger2.ui.main.MainActivity;
import com.bsrakdg.advanceddagger2.viewmodels.ViewModelProviderFactory;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AuthActivity";

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    private AuthViewModel viewModel;
    private EditText userId;
    private ProgressBar progressBar;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
            attemptLogin();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        userId = findViewById(R.id.user_id_input);
        findViewById(R.id.login_button).setOnClickListener(this);
        progressBar = findViewById(R.id.progress_bar);

        viewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);

        setLogo();

        subscribeObservers();
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        viewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void onLoginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void subscribeObservers() {
        viewModel.observeAuthState().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING:
                            showProgressBar(true);
                            break;
                        case ERROR:
                            Toast.makeText(AuthActivity.this, userAuthResource.message
                                    + getString(R.string.error_login), Toast.LENGTH_LONG).show();
                            showProgressBar(false);
                            break;
                        case NOT_AUTHENTICATED:
                            showProgressBar(false);
                            break;
                        case AUTHENTICATED:
                            Log.d(TAG, "onChanged: LOGIN SUCCESS : " + userAuthResource.data
                                    .getEmail());
                            showProgressBar(false);
                            onLoginSuccess();
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }
    private void setLogo() {
        requestManager
                .load(logo)
                .into((ImageView) findViewById(R.id.login_logo));
    }
}
