package com.bsrakdg.advanceddagger2.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bsrakdg.advanceddagger2.R;
import com.bsrakdg.advanceddagger2.models.Post;
import com.bsrakdg.advanceddagger2.ui.main.Resource;
import com.bsrakdg.advanceddagger2.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {
    private static final String TAG = "PostsFragment";

    @Inject
    ViewModelProviderFactory providerFactory;

    private PostsViewModel viewModel;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);

        viewModel = new ViewModelProvider(this, providerFactory).get(PostsViewModel.class);

        subscribeObservers();
    }

    private void subscribeObservers() {
        viewModel.observePosts().removeObservers(getViewLifecycleOwner());
        viewModel.observePosts()
                .observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
                    @Override
                    public void onChanged(Resource<List<Post>> listResource) {
                        if (listResource != null) {
                            Log.d(TAG, "onChanged: " + listResource.data);
                        }
                    }
                });
    }
}
