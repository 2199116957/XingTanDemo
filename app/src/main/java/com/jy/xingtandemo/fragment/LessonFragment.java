package com.jy.xingtandemo.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jy.mvplivrary.base.BaseFragment;
import com.jy.xingtandemo.R;
import com.jy.xingtandemo.contart.HomeContart;
import com.jy.xingtandemo.presenter.HomePressenter;
import com.youth.banner.Banner;

/**
 * 选课
 */
public class LessonFragment extends BaseFragment<HomePressenter> implements HomeContart.IHomeView {

    private TextView mLessonTime;
    private LinearLayout mLessonTopcenterTxt;
    private Banner mBannerLesson;
    private TabLayout mTabLesson;
    private TextView mTextAll;
    private ViewPager mLessonVp;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

        mLessonTime = (TextView) view.findViewById(R.id.lesson_time);
        mLessonTopcenterTxt = (LinearLayout) view.findViewById(R.id.lesson_topcenter_txt);
        mBannerLesson = (Banner) view.findViewById(R.id.banner_lesson);
        mTabLesson = (TabLayout) view.findViewById(R.id.tab_lesson);
        mTextAll = (TextView) view.findViewById(R.id.text_all);
        mLessonVp = (ViewPager) view.findViewById(R.id.lesson_vp);
    }

    @Override
    public HomePressenter getPresenter() {
        return new HomePressenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_lesson;
    }

    @Override
    public <T> void getHome(T t) {

    }

    @Override
    public <T> void getHomeCaregory(T t) {

    }

    @Override
    public void getno(String str_no) {

    }
}