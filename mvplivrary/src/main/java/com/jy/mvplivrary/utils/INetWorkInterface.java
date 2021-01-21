package com.jy.mvplivrary.utils;

import java.util.HashMap;

import okhttp3.RequestBody;

public interface INetWorkInterface {
    <T> void get(String url, HashMap<String, String> map, INetCallBack<T> callBack);
    <T> void post(String url, HashMap<String, String> map, INetCallBack<T> callBack);
    <T> void postRequestBody(String url , RequestBody body, INetCallBack<T> callBack);

    /*
    <T> void get(String str, com.jy.mvpli.ueils.INetCallBack<T> callBack);


    <T> void get(String url, int id, int page, int size, com.jy.mvpli.ueils.INetCallBack<T> callBack);

    <T> void getId(String url, int id, int page, int size, com.jy.mvpli.ueils.INetCallBack<T> callBack);

    <T> void get1(String str, int id, com.jy.mvpli.ueils.INetCallBack<T> callBack);

    //添加购物车
    <T> void getAdd(String url, Map<String, String> map, com.jy.mvpli.ueils.INetCallBack<T> callBack);

    //删除购物车
    <T> void getDelete(String url, String pIds, com.jy.mvpli.ueils.INetCallBack<T> callBack);

    <T> void post(String str, com.jy.mvpli.ueils.INetCallBack<T> callBack);

    <T> void post(String str, HashMap<String, String> map, com.jy.mvpli.ueils.INetCallBack<T> callBack);*/
}
