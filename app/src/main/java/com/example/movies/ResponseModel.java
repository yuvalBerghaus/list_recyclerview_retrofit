package com.example.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {
    @SerializedName("results")
    @Expose
    private List<DataModel> results = null;

    public List<DataModel> getResults() {
        return results;
    }
}
