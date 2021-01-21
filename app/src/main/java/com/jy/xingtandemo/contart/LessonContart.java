package com.jy.xingtandemo.contart;

import com.jy.mvplivrary.base.BaseModel;
import com.jy.mvplivrary.base.BaseView;
import com.jy.mvplivrary.utils.INetCallBack;
import com.jy.xingtandemo.fragment.HomeFragment;

import okhttp3.RequestBody;

public class LessonContart {
    public interface IHomeView extends BaseView {
        <T> void getTime(T t);//首页

        void getno(String str_no);

    }

    public interface IHomeModel extends BaseModel {

        <T> void getLessonTime(String url, RequestBody requestBody, INetCallBack<T> callBack);

    }

    public interface IHomePresenter {

        void getLessonTime(String url, String id, HomeFragment.RequestResult requestResult);
    }
}
