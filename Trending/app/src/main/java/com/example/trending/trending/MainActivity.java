package com.example.trending.trending;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trending.R;
import com.example.trending.base.BaseActivity;
import com.example.trending.base.BasePresenter;

public class MainActivity extends BaseActivity<MainPresenter>{

    private MainPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private Adapter adapter;

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
}