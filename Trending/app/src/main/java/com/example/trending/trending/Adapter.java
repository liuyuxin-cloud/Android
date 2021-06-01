package com.example.trending.trending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trending.ItemsBean;
import com.example.trending.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<ItemsBean> mItemsBeans;

    public Adapter(List<ItemsBean> itemsBeans){
        this.mItemsBeans = itemsBeans;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mView;
        private final TextView mName;
        private final TextView mRepo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.view);
            mName = itemView.findViewById(R.id.user);
            mRepo = itemView.findViewById(R.id.repo);
        }
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        holder.mView.setImageURI(mItemsBeans.get(position).OwnerBean);
        holder.mName.setText(mItemsBeans.get(position).getName());
        holder.mRepo.setText(mItemsBeans.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}


