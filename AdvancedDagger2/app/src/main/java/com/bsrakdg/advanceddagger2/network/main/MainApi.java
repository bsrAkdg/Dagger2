package com.bsrakdg.advanceddagger2.network.main;

import com.bsrakdg.advanceddagger2.models.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    // posts?userId=1
    @GET("posts")
    Flowable<List<Post>> getPostsFromUser(@Query("userId") int id);
}
