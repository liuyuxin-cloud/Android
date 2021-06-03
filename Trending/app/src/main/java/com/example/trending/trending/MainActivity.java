package com.example.trending.trending;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.example.trending.API;
import com.example.trending.ItemsBean;
import com.example.trending.R;
import com.example.trending.base.BaseActivity;
import com.example.trending.base.BasePresenter;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements API.VP {

    private RecyclerView mRecyclerView;
    public static final String BaseURL = "https://trendings.herokuapp.com/";
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initListener();
        initView();
        initData();
        mPresenter = getPresenterInstance();
        mPresenter.bindView(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView() {

        mRecyclerView = findViewById(R.id.re_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


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
        return new MainPresenter();
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
    public void setData(List<ItemsBean> list) {
        Adapter adapter = new Adapter(list);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void Fail() {

    }
}