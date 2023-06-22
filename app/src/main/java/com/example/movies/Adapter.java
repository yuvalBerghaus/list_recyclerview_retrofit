package com.example.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context mContext;
    private List<DataModel> movieList;

    public Adapter(Context mContext, List<DataModel> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        v = layoutInflater.inflate(R.layout.item , parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(movieList.get(position).getName());
        Glide.with(mContext).load(movieList.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titlee);
            img = itemView.findViewById(R.id.image);
        }
    }
}
