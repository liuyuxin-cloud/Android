package com.example.trending.trending;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.trending.API;
import com.example.trending.ItemsBean;
import com.example.trending.R;
import com.example.trending.base.BaseActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
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
        Fresco.initialize(this);
    }

    @Override
    protected void initData() {
        refreshList();
    }

    @Override
    public void initView() {

        mRecyclerView = findViewById(R.id.re_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        Animation animation = AnimationUtils.loadAnimation(
                this, R.anim.list_anim);
        LayoutAnimationController lac = new LayoutAnimationController(animation);
        lac.setDelay(0.4f);  //设置动画间隔时间
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL); //设置列表的显示顺序
        mRecyclerView.setLayoutAnimation(lac);
        lac.start();//为ListView 添加动画

        mSwipeRefreshLayout = findViewById(R.id.refresh);
        mSwipeRefreshLayout.setRefreshing(true);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.gray, R.color.purple_200, R.color.black);//设置下拉进度条颜色
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