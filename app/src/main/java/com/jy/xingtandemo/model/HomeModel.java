package com.jy.xingtandemo.model;

import com.google.gson.Gson;
import com.jy.mvplivrary.utils.INetCallBack;
import com.jy.mvplivrary.utils.RetrofitUtils;
import com.jy.xingtandemo.bean.HomeBannerBody;
import com.jy.xingtandemo.bean.HomeCaregoryBody;
import com.jy.xingtandemo.contart.HomeContart;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HomeModel implements HomeContart.IHomeModel {
    @Override
    public <T> void getHomeData(String url, INetCallBack<T> callBack) {

        HomeBannerBody homeBannerBean = new HomeBannerBody();

        homeBannerBean.setAdvLocation("7");
        homeBannerBean.setPlatShow("0");

        Gson gson = new Gson();
        String s = gson.toJson(homeBannerBean);
//        { "advLocation": 7,"platShow": 0 }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), s);

        RetrofitUtils.getInstance().postRequestBody(url,requestBody,callBack);
    }

    @Override
    public <T> void getHomeCaregoryData(String url, INetCallBack<T> callBack) {
        HomeCaregoryBody homeCaregoryBody = new HomeCaregoryBody();
        homeCaregoryBody.setType("0");
        Gson gson = new Gson();
        String s = gson.toJson(homeCaregoryBody);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), s);
        RetrofitUtils.getInstance().postRequestBody(url,requestBody,callBack);
    }

    @Override
    public <T> void getStairImage(String url, RequestBody requestBody, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().postRequestBody(url, requestBody, callBack);
    }


}
