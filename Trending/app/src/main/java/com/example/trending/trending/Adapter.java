package com.example.trending.trending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trending.R;

public class Adapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    private ImageView mView;
    private TextView mName;
    private TextView mRepo;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView.findViewById(R.id.view);
        mName = itemView.findViewById(R.id.user);
        mRepo = itemView.findViewById(R.id.repo);
    }
}

