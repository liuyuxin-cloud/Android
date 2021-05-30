package com.example.trending.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements View.OnClickListener {

    private static final String BaseURL = "https ://trendings.herokuapp.com/";

    public P myPresenter;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(getContentViewId());
        initListener();
        initView();
        initData();
        myPresenter = getPresenterInstance();
        myPresenter.bindView(this);
    }

    protected abstract void initData();

    public abstract void initView();
    public abstract int getContentViewId();
    public abstract void initListener();
    public abstract P getPresenterInstance();


    @Override
    protected void onDestroy(){
        super.onDestroy();

        destroy();
    }
    public abstract void destroy();

}
