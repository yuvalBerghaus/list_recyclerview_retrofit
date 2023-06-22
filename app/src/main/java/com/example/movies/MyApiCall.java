package com.example.movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {
    //https://run.mocky.io/         v3/d862875d-7960-498c-b538-a1f3ffea1b9a

    @GET("v3/c38ef967-0c43-4cbb-b4a0-1f330e2d33b7")
    Call<List<DataModel>>getMovieList();
}
