package com.example.trending.trending;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trending.ItemsBean;
import com.example.trending.R;

import java.util.List;

import retrofit2.http.Url;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<ItemsBean.Items> mItemsBeans;
    private int opened = -1;

    public Adapter(List<ItemsBean.Items> itemsBeans) {
        this.mItemsBeans = itemsBeans;
    }

    public void setList(List<ItemsBean.Items> itemsBeans) {
        this.mItemsBeans = itemsBeans;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mView;
        private final TextView mName;
        private final TextView mRepo;
        private final TextView mDes;
        private final TextView mStars;
        private final TextView mForks;
        private ConstraintLayout mConcrete;
        private LinearLayout mSummary;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.imageView);
            mName = itemView.findViewById(R.id.user);
            mRepo = itemView.findViewById(R.id.repo);
            mDes = itemView.findViewById(R.id.des);
            mStars = itemView.findViewById(R.id.star_count);
            mForks = itemView.findViewById(R.id.fork_count);

            mConcrete = itemView.findViewById(R.id.constraintLayout1);
            mSummary = itemView.findViewById(R.id.summary);
            mSummary.setOnClickListener(this);
        }

        void bindView(int pos, ItemsBean.Items items) {

            List<String> str = items.getAvatars();
            Uri url = Uri.parse(str.get(0));
            mView.setImageURI(url);
            mName.setText(items.getRepo());
            mRepo.setText(items.getRepo_link());
            mStars.setText(String.valueOf(items.getStars()));
            mForks.setText(String.valueOf(items.getForks()));
            if (items.getDesc() != null) {
                mDes.setText(items.getDesc());
            }

            if (pos == opened) {
                mConcrete.setVisibility(View.VISIBLE);
            } else {
                mConcrete.setVisibility(View.GONE);
            }
        }

        @Override
        public void onClick(View v) {
            if (opened == getAdapterPosition()) {
                opened = -1;
                notifyItemChanged(getAdapterPosition());
            } else {
                int oldOpened = opened;
                opened = getAdapterPosition();
                notifyItemChanged(oldOpened);
                notifyItemChanged(opened);
            }
        }
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        holder.bindView(position, mItemsBeans.get(position));

    }

    @Override
    public int getItemCount() {
        return mItemsBeans.size() ;
    }
}

