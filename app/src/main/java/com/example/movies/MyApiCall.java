package com.example.movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApiCall {
    //https://api.themoviedb.org/3/movie/top_rated?api_key=3c891b1006d9bdf7725711a9834ce4e2
    //https://api.themoviedb.org/3/movie/top_rated?api_key={api_key}

    @GET("3/movie/top_rated")
    Call<ResponseModel> movieList(@Query("api_key") String api_key);
}
