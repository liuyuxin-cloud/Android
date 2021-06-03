package com.example.trending;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    public interface M {        //M层请求业务
        void request();

    }
    public interface VP{
        void refreshList();
        void setData(List<ItemsBean> list);
        void Fail();

    }


    @GET("/repo")
    Observable<List<ItemsBean>> getList(@Query("lang")String language, @Query("since")String weekly);



}
