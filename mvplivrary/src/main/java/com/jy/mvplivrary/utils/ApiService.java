package com.jy.mvplivrary.utils;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface ApiService {

    @POST
    @FormUrlEncoded
    Flowable<ResponseBody> post(@Url String url, @FieldMap HashMap<String, String> parm);

    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap HashMap<String, String> parm);
    @POST
    Observable<ResponseBody> postRequestBody(@Url String url , @Body RequestBody requestBody);
}
