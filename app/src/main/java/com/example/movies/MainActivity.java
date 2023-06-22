package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    List<DataModel> movieList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        //Retrofit builder
        movieList = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApiCall service = retrofit.create(MyApiCall.class);
        Call<List<DataModel>> call = service.getMovieList();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if(response.code() != 200) {
                    Log.d("connection", "wrong connection");
                }
                movieList = response.body();
                PutDataIntoRecyclerView(movieList);
                Log.d("movie", movieList.toString());
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

                Log.d("connection", t.getMessage());
            }
        });
    }

    private void PutDataIntoRecyclerView(List<DataModel> movieList) {
        Adapter adapter = new Adapter(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}