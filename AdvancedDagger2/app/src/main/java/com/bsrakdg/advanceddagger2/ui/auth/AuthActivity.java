package com.bsrakdg.advanceddagger2.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bsrakdg.advanceddagger2.R;
import com.bsrakdg.advanceddagger2.models.User;
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                attemtLogin();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        userId = findViewById(R.id.user_id_input);
        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);

        setLogo();

        subscribeObservers();
    }

    private void attemtLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        viewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
    }

    private void subscribeObservers() {
        viewModel.observableUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    Log.d(TAG, "onChanged: " + user.getEmail());
                } else {
                    Log.e(TAG, "onChanged: USER IS NULL" );
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
