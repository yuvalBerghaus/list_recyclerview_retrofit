package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        overview.setText(intent.getStringExtra("overview"));
        Log.d("overview",intent.getStringExtra("overview") );
//        https://image.tmdb.org/t/p/w200/
        Glide.with(this).load("https://image.tmdb.org/t/p/w200/"+intent.getStringExtra("image")).into(image);
    }
}