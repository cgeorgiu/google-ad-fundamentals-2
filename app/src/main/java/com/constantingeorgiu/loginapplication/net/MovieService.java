package com.constantingeorgiu.loginapplication.net;

import com.constantingeorgiu.loginapplication.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("/movies")
    Call<List<Movie>> getMovies();
}
