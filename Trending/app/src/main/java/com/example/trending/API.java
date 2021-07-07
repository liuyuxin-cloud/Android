package com.example.trending;

import java.util.List;

import io.reactivex.Observable;
import ren.yale.android.retrofitcachelib.anno.Cache;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    public interface M {        //M层请求业务
        void request();
    }
    public interface VP{
        void refreshList();
        void onSuccess(List<ItemsBean.Items> list);
        void setData(List<ItemsBean.Items> list);
        void Fail();
    }

    @Cache()
    @GET("/repo")
    Observable<ItemsBean<ItemsBean.Items>> getList(@Query("lang")String language, @Query("since")String weekly);



}
