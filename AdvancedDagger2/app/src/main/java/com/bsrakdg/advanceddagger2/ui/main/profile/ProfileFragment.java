package com.bsrakdg.advanceddagger2.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bsrakdg.advanceddagger2.R;
import com.bsrakdg.advanceddagger2.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {
    private static final String TAG = "ProfileFragment";

    private ProfileViewModel profileViewModel;

    @Inject
    ViewModelProviderFactory providerFactory;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Profile fragment create", Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: Profile fragment was created");

        profileViewModel = new ViewModelProvider(this, providerFactory).get(ProfileViewModel.class);
    }
}
