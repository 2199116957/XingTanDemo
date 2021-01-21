package com.jy.mvplivrary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePreenter> extends Fragment implements BaseView {
    protected P presenter;
    protected Context mcontext;
    private boolean isViewShow = false;
    private boolean isDataLoad = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutID(), container, false);
        mcontext=getContext();
        if (presenter == null) {
            presenter = getPresenter();
            presenter.attachView(this);
        }
        initView(inflate);
        initData();
        isViewShow = true;
        return inflate;
    }


    protected abstract void initData();

    protected abstract void initView(View view);

    public abstract P getPresenter();

    protected abstract int getLayoutID();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyLoad();
    }

    private void lazyLoad() {
        if (getUserVisibleHint() && isViewShow && !isDataLoad) {
            initData();
            isDataLoad = true;
        }
    }

    ;


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
