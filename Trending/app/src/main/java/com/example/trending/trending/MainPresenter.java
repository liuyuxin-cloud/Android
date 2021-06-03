package com.example.trending.trending;

import com.example.trending.API;
import com.example.trending.base.BaseModel;
import com.example.trending.base.BasePresenter;

import java.util.List;

public class MainPresenter extends BasePresenter<MyModel,MainActivity> implements API.VP{

    public void bindView(MainActivity mView){ //绑定View
        this.mView = mView;
    }
    public void unBindView(){
        this.mView = null;
    }

    @Override
    public MyModel getModelInstance() {
        return new MyModel(this);
    }

    @Override
    public void refreshList() {
        mModel.request();
    }

    @Override
    public void setData(List list) {
        mView.setData(list);
    }

    @Override
    public void Fail() {
        mView.Fail();
    }
}
