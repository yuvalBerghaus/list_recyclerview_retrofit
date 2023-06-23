package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Movie_Details extends AppCompatActivity {
    TextView title;
    TextView overview;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        title = findViewById(R.id.title_detail);
        overview = findViewById(R.id.overview_detail);
        image = findViewById(R.id.image_detail);

    }
}