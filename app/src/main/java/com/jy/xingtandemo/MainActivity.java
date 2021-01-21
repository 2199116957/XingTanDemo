package com.jy.xingtandemo;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;
import com.jy.xingtandemo.fragment.HomeFragment;
import com.jy.xingtandemo.fragment.LessonFragment;
import com.jy.xingtandemo.fragment.MyFragment;
import com.jy.xingtandemo.fragment.QuesFragment;
import com.jy.xingtandemo.fragment.TopicFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mMainFragment;
    private TabLayout mMainTab;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        mMainFragment = (FrameLayout) findViewById(R.id.main_fragment);
        mMainTab = (TabLayout) findViewById(R.id.main_tab);
        HomeFragment homeFragment = new HomeFragment();//首页
        QuesFragment quesFragment = new QuesFragment();//题库
        LessonFragment lessonFragment = new LessonFragment();//选课
        TopicFragment topicFragment = new TopicFragment();//学习
        MyFragment myFragment = new MyFragment();//我的
        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .show(homeFragment)
                .hide(quesFragment)
                .hide(lessonFragment)
                .hide(topicFragment)
                .hide(myFragment)
                .add(R.id.main_fragment, homeFragment)
                .add(R.id.main_fragment, quesFragment)
                .add(R.id.main_fragment, lessonFragment)
                .add(R.id.main_fragment, topicFragment)
                .add(R.id.main_fragment, myFragment)
                .commit();

        mMainTab.addTab(mMainTab.newTab().setText("首页").setIcon(R.drawable.select_home));
        mMainTab.addTab(mMainTab.newTab().setText("题库").setIcon(R.drawable.select_learn));
        mMainTab.addTab(mMainTab.newTab().setText("选课").setIcon(R.drawable.select_lesson));
        mMainTab.addTab(mMainTab.newTab().setText("学习").setIcon(R.drawable.select_topic));
        mMainTab.addTab(mMainTab.newTab().setText("我的").setIcon(R.drawable.select_mi));
        mMainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        supportFragmentManager.beginTransaction()
                                .show(homeFragment)
                                .hide(quesFragment)
                                .hide(lessonFragment)
                                .hide(topicFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case 1:
                        supportFragmentManager.beginTransaction()
                                .show(quesFragment)
                                .hide(homeFragment)
                                .hide(lessonFragment)
                                .hide(topicFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case 2:
                        supportFragmentManager.beginTransaction()
                                .show(lessonFragment)
                                .hide(quesFragment)
                                .hide(homeFragment)
                                .hide(topicFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case 3:
                        supportFragmentManager.beginTransaction()
                                .show(topicFragment)
                                .hide(quesFragment)
                                .hide(lessonFragment)
                                .hide(homeFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case 4:
                        supportFragmentManager.beginTransaction()
                                .show(myFragment)
                                .hide(quesFragment)
                                .hide(lessonFragment)
                                .hide(topicFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}