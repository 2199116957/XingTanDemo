package com.jy.xingtandemo.contart;

import com.jy.mvplivrary.base.BaseModel;
import com.jy.mvplivrary.base.BaseView;
import com.jy.mvplivrary.utils.INetCallBack;
import com.jy.xingtandemo.fragment.HomeFragment;

import okhttp3.RequestBody;

public class HomeContart {

    public interface IHomeView extends BaseView {
        <T> void getHome(T t);//首页

        <T> void getHomeCaregory(T t);

        void getno(String str_no);

    }

    public interface IHomeModel extends BaseModel {
        <T> void getHomeData(String url, INetCallBack<T> callBack);

        <T> void getHomeCaregoryData(String url, INetCallBack<T> callBack);

        <T> void getStairImage(String url, RequestBody requestBody, INetCallBack<T> callBack);

    }

    public interface IHomePresenter {
        void getHome();

        void getHomeCaregory();

        void getStairImage(String url, String id1, String id2, HomeFragment.RequestResult requestResult);
    }
}
