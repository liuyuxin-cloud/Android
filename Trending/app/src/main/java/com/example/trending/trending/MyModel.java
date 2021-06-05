package com.example.trending.trending;


import com.example.trending.API;
import com.example.trending.ItemsBean;
import com.example.trending.base.BaseModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.trending.trending.MainActivity.BaseURL;

public class MyModel extends BaseModel<MainPresenter> implements API.M {

    private List<ItemsBean.Items> mList = new ArrayList<>();

    public MyModel(MainPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public void request() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        API mApi = retrofit.create(API.class);
        mApi.getList("java", "weekly").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemsBean<ItemsBean.Items>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ItemsBean<ItemsBean.Items> itemsItemsBean) {
                        for (int i = 0; i < itemsItemsBean.getItems().size(); i++) {
                            mList.add(itemsItemsBean.getItems().get(i));
                        }
                        mPresenter.onSuccess(mList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mPresenter.Fail();
                    }

                    @Override
                    public void onComplete() {
                        mPresenter.setData(mList);

                    }
                });
    }
}
