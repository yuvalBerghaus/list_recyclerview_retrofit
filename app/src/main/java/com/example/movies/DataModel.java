package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class DataModel {
    // This model class will be as a template for the data that we are going to parse

    private String id;
    private String name;
    private String image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
