package com.example.endterm.api.service;

import java.util.List;

import com.example.endterm.api.model.GitHubRepo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by norman on 12/26/16.
 */

public interface GitHubClient {

    @GET("/{user}")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);
}
