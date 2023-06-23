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
    public String api = "3c891b1006d9bdf7725711a9834ce4e2";
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
                .baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApiCall service = retrofit.create(MyApiCall.class);
        Log.d("chgeck", api);
        Call<ResponseModel> call = service.movieList(api);
        Log.d("check api", api);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.code() != 200) {
                    Log.d("connection", "wrong connection");
                }
                movieList = response.body().getResults();
                PutDataIntoRecyclerView(movieList);
                Log.d("movie", movieList.toString());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

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