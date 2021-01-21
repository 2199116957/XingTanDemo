package com.jy.xingtandemo.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.jy.mvplivrary.base.BasePreenter;
import com.jy.mvplivrary.utils.INetCallBack;
import com.jy.mvplivrary.utils.UrlConstant;
import com.jy.xingtandemo.bean.HomeBannerBean;
import com.jy.xingtandemo.bean.HomeCaregoryBean;
import com.jy.xingtandemo.bean.HomeStairImageBean;
import com.jy.xingtandemo.bean.HomeStairImageBodyBean;
import com.jy.xingtandemo.contart.HomeContart;
import com.jy.xingtandemo.fragment.HomeFragment;
import com.jy.xingtandemo.model.HomeModel;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HomePressenter extends BasePreenter<HomeContart.IHomeView, HomeContart.IHomeModel> implements HomeContart.IHomePresenter {

    @Override
    public HomeContart.IHomeModel getiModel() {
        return new HomeModel();
    }

    @Override
    public void getHome() {

        iModel = new HomeModel();
        iModel.getHomeData(UrlConstant.HOME_BANNER, new INetCallBack<HomeBannerBean>() {
            @Override
            public void onYes(HomeBannerBean homeBannerBean) {
                if (homeBannerBean.getCode()==200){
                    iView.getHome(homeBannerBean);
                    Log.e("TAG", "主页轮播图请求成功请求");
                }else{
                    Log.e("TAG", "主页轮播图请求失败");
                }

            }

            @Override
            public void onNo(String str_no) {
                Log.e("TAG", "主页轮播图解析失败"+str_no);
                iView.getno(str_no);
            }
        });

    }

    @Override
    public void getHomeCaregory() {
        iModel.getHomeCaregoryData(UrlConstant.HOME_CAREGORY, new INetCallBack<HomeCaregoryBean>() {
            @Override
            public void onYes(HomeCaregoryBean homeCaregoryBean) {
                if (homeCaregoryBean.getCode()==200){
                    iView.getHomeCaregory(homeCaregoryBean);
                    Log.e("TAG", "主页一级列表请求成功请求");
                }else{
                    Log.e("TAG", "主页一级列表请求失败");
                }
            }

            @Override
            public void onNo(String str_no) {
                Log.e("TAG", "主页一级列表解析失败"+str_no);
                iView.getno(str_no);
            }
        });
    }

    @Override
    public void getStairImage(String url, String id1, String id2, HomeFragment.RequestResult requestResult) {
        HomeStairImageBodyBean homeStairImageBodyBean = new HomeStairImageBodyBean();
        homeStairImageBodyBean.setCategoryId1(id1);
        homeStairImageBodyBean.setCategoryId2(id2);
        homeStairImageBodyBean.setType("0");
        Gson gson = new Gson();
        String s = gson.toJson(homeStairImageBodyBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), s);
        iModel.getStairImage(url, requestBody, new INetCallBack<HomeStairImageBean>() {
            @Override
            public void onYes(HomeStairImageBean homeStairImageBean) {
                if (homeStairImageBean.getCode()==200){
                    requestResult.onSuccess(homeStairImageBean);
                    Log.e("TAG", "主页二级列表请求成功请求");
                }else{
                    Log.e("TAG", "主页二级列表请求失败");
                }
            }

            @Override
            public void onNo(String error) {
                Log.e("TAG", "主页二级列表请求失败");
            }
        });
    }


}
