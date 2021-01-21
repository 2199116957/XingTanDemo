package com.jy.mvplivrary.utils;

public interface INetCallBack<T> {
    public void onYes(T t);

    public void onNo(String str_no);
}
