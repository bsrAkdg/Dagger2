package com.bsrakdg.advanceddagger2.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bsrakdg.advanceddagger2.R;
import com.bsrakdg.advanceddagger2.models.User;
import com.bsrakdg.advanceddagger2.ui.auth.AuthResource;
import com.bsrakdg.advanceddagger2.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {
    private static final String TAG = "ProfileFragment";

    private ProfileViewModel profileViewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    private TextView email, username, website;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: Profile fragment was created");

        email = view.findViewById(R.id.email);
        username = view.findViewById(R.id.username);
        website = view.findViewById(R.id.website);

        profileViewModel = new ViewModelProvider(this, providerFactory).get(ProfileViewModel.class);

        // DON'T DO THIS !!!!!
        // Every time view created you receive an instance
        // Best way receive session manager you should use subscribe own lifecycle owner :
        // subscribeObservers()
        /*AuthResource<User> user = ((MainActivity) getActivity()).sessionManager.getAuthUser()
                .getValue();*/

        subscribeObservers();
    }

    private void setErrorDetails(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    private void setUserDetails(User data) {
        username.setText(data.getUsername());
        email.setText(data.getEmail());
        website.setText(data.getWebsite());
    }

    private void subscribeObservers() {
        // When Fragments replaced or destroyed, old observers are not deleted by activity, you should remove
        profileViewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner());

        profileViewModel.getAuthenticatedUser()
                .observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
                    @Override
                    public void onChanged(AuthResource<User> userAuthResource) {
                        if (userAuthResource != null) {
                            switch (userAuthResource.status) {
                                case AUTHENTICATED:
                                    setUserDetails(userAuthResource.data);
                                    break;
                                case ERROR:
                                    setErrorDetails(userAuthResource.message);
                                    break;
                            }
                        }
                    }
                });

    }
}
