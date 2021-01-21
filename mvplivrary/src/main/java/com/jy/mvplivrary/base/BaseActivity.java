package com.jy.mvplivrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePreenter> extends AppCompatActivity implements BaseView {

    public P pressenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if (pressenter == null) {
            pressenter = getPressenter();
            pressenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract int getLayoutID();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P getPressenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pressenter != null) {
            pressenter.detachView();
        }
    }
}
