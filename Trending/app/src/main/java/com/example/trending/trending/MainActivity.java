package com.example.trending.trending;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.trending.API;
import com.example.trending.ItemsBean;
import com.example.trending.R;
import com.example.trending.base.BaseActivity;
import com.google.android.material.behavior.SwipeDismissBehavior;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements API.VP {

    private RecyclerView mRecyclerView;
    public static final String BaseURL = "https://trendings.herokuapp.com/";
    private final MainPresenter mPresenter = new MainPresenter();
    Adapter adapter;
    private List<ItemsBean.Items> mList;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mPresenter.bindView(this);
        initListener();
        initData();
        initView();
    }

    @Override
    protected void initData() {
        refreshList();
    }

    @Override
    public void initView() {

        refreshList();

        mRecyclerView = findViewById(R.id.re_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));



        mSwipeRefreshLayout = findViewById(R.id.refresh);
        mSwipeRefreshLayout.setRefreshing(true);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.gray,R.color.white,R.color.black);//设置下拉进度条颜色
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
            }
        });




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
    public void onSuccess(List<ItemsBean.Items> list) {
        setData(list);
    }

    @Override
    public void setData(List<ItemsBean.Items> list) {
        mList = list;
        adapter = new Adapter(mList);
        mRecyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void Fail() {

    }
}