package com.jy.mvplivrary.utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils implements INetWorkInterface {

    private static volatile RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;
    private final ApiService apiServices;

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    private RetrofitUtils() {

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(chain -> {
                            Log.e("TAG", "执行添加请求头操作");
                            Request request = chain.request();
                            Request.Builder builder = request.newBuilder();
                            MMKV mmkv = MMKV.defaultMMKV();
                            String token = mmkv.decodeString("TOKEN", "");
                            builder.addHeader("TOKEN", token);
                            Request build = builder.build();
                            return chain.proceed(build);
                        }
                )
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiServices = retrofit.create(ApiService.class);
    }

    @Override
    public <T> void get(String url, HashMap<String, String> map, INetCallBack<T> callBack) {
        apiServices.get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            T json = new Gson().fromJson(string, type);
                            callBack.onYes(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        callBack.onNo("网络异常sss："+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, INetCallBack<T> callBack) {
        apiServices.post(url, map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();

                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type actualTypeArgument = actualTypeArguments[0];
                            T fromJson = new Gson().fromJson(string, actualTypeArgument);
                            callBack.onYes(fromJson);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("TAG", "RetrofitUtils错误信息" + t.toString());
                        callBack.onNo(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void postRequestBody(String url, RequestBody body, INetCallBack<T> callBack) {
        apiServices.postRequestBody(url,body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@androidx.annotation.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@androidx.annotation.NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type actualTypeArgument = actualTypeArguments[0];
                            T fromJson = new Gson().fromJson(string, actualTypeArgument);
                            callBack.onYes(fromJson);
                            Log.i("TAG", "RetrofitUtils"+fromJson.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onNo(e.toString());
                        Log.i("TAG", "RetrofitUtils错误信息" + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
