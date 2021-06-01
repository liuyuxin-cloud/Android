package com.example.trending.trending;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.example.trending.API;
import com.example.trending.R;
import com.example.trending.base.BaseActivity;
import com.example.trending.base.BasePresenter;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements API.VP {

    private MainPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private Adapter adapter;
    public static final String BaseURL = "https://api.github.com/search/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initListener();
        initView();
        initData();
        myPresenter = getPresenterInstance();
        myPresenter.bindView(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView() {

        mRecyclerView = findViewById(R.id.re_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initListener() {

    }

    @Override
    public MainPresenter getPresenterInstance() {
        return mPresenter;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void refreshList() {
        mPresenter.refreshList();
    }

    @Override
    public void setData(List list) {

    }

    @Override
    public void Fail() {

    }
}