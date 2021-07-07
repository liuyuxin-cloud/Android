package com.example.trending.trending;


import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trending.API;
import com.example.trending.ItemsBean;
import com.example.trending.base.BaseModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import ren.yale.android.retrofitcachelib.RetrofitCache;
import ren.yale.android.retrofitcachelib.intercept.CacheForceInterceptorNoNet;
import ren.yale.android.retrofitcachelib.intercept.CacheInterceptorOnNet;
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
        okhttp3.OkHttpClient.Builder clientBuilder=new okhttp3.OkHttpClient.Builder();
        int cacheSize = 200 * 1024 * 1024;
        File cacheDirectory = new File(Environment.getExternalStorageDirectory(), "httpcache");
        Cache cache = new Cache(cacheDirectory, cacheSize);
        OkHttpClient client =  clientBuilder.cache(cache).build();
        clientBuilder.addInterceptor(new CacheForceInterceptorNoNet());
        clientBuilder.addNetworkInterceptor(new CacheInterceptorOnNet());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        RetrofitCache.getInstance().addRetrofit(retrofit);

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
