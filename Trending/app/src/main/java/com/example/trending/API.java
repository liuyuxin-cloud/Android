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


    @GET("/repositories")
    Observable<List<ItemsBean>> getList(@Query("sort")String sort, @Query("q")String language);



}
