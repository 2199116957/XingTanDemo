package com.jy.xingtandemo.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jy.mvplivrary.base.BaseFragment;
import com.jy.mvplivrary.utils.UrlConstant;
import com.jy.xingtandemo.R;
import com.jy.xingtandemo.adap.CaregoryAdap;
import com.jy.xingtandemo.adap.HomeStairImageAdap;
import com.jy.xingtandemo.adap.LanGeAdapter;
import com.jy.xingtandemo.adap.LanGetowAdapter;
import com.jy.xingtandemo.bean.HomeBannerBean;
import com.jy.xingtandemo.bean.HomeCaregoryBean;
import com.jy.xingtandemo.bean.HomeStairImageBean;
import com.jy.xingtandemo.contart.HomeContart;
import com.jy.xingtandemo.presenter.HomePressenter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<HomePressenter> implements HomeContart.IHomeView {

    private RecyclerView mHomeRecycler;
    private ArrayList<HomeBannerBean.DataDTO.AdvListDTO> banner;
    private VirtualLayoutManager layoutManager;
    private DelegateAdapter adapter;
    private LanGeAdapter lanGeAdapter;
    private LanGetowAdapter lanGetowAdapter;
    private ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean> courseCategoryListBeans;
    private CaregoryAdap caregoryAdap;
    private HomeStairImageAdap homeStairAdapter;
    @Override
    protected void initData() {
        presenter.getHome();
        presenter.getHomeCaregory();
//        presenter.getStairImage();
    }

    @Override
    protected void initView(View view) {
        banner = new ArrayList<>();//Banner集合

        mHomeRecycler = (RecyclerView) view.findViewById(R.id.home_recycler);
        layoutManager = new VirtualLayoutManager(getContext());

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mHomeRecycler.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 15);

        lanGeAdapter = initLanGe();//banner
        lanGetowAdapter = initChannel();//banner下图标
        caregoryAdap = initCaregory();

        initAddAdapter();
        initRecyclerViewSet();
        initOnClickItem();
    }

    public interface RequestResult<P> {
        void onSuccess(P bean);
    }
    private void initOnClickItem() {
        caregoryAdap.setOnItemClick(new CaregoryAdap.OnItemClick() {
            @Override
            public void setOnClickTitle(int onePostion, int twoPostion,
                                        ArrayList<HomeStairImageBean.DataBean.CourseGradeListBean> listBeans,
                                        HomeStairImageAdap homeStairImageAdap) {
                String id = courseCategoryListBeans.get(onePostion).getId();
                String id1 = courseCategoryListBeans.get(onePostion).getSubList().get(twoPostion).getId();
                presenter.getStairImage(UrlConstant.HOME_CLASSIFYSCOED, id, id1, new RequestResult<HomeStairImageBean>() {
                    @Override
                    public void onSuccess(HomeStairImageBean bean) {
                        listBeans.clear();
                        listBeans.addAll(bean.getData().getCourseGradeList());
                        Log.d("TAG", "onSuccess: "+listBeans.size());
                        homeStairImageAdap.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private CaregoryAdap initCaregory() {
        GridLayoutHelper singleLayoutHelper = new GridLayoutHelper(1);
        courseCategoryListBeans = new ArrayList<>();//列表一级数据
        // 公共属性
        singleLayoutHelper.setItemCount(courseCategoryListBeans.size());
        singleLayoutHelper.setAspectRatio(1.4f);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        CaregoryAdap caregoryAdap = new CaregoryAdap(
                singleLayoutHelper, courseCategoryListBeans,linearLayoutHelper,getActivity());

        return caregoryAdap;
    }

    private LanGeAdapter initLanGe() {//banner
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 公共属性
        columnLayoutHelper.setItemCount(1);// 设置布局里Item个数
        columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        LanGeAdapter geAdapter = new LanGeAdapter(columnLayoutHelper, banner);
        return geAdapter;
    }

    private LanGetowAdapter initChannel() {//Banner下的导航
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setPadding(0, 0, 0, 0);
        singleLayoutHelper.setMargin(0, 0, 0, 20);
        singleLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        LanGetowAdapter getowAdapter1 = new LanGetowAdapter(singleLayoutHelper);
        //=-----------------------------------------------------------------------------------

        return getowAdapter1;
    }

    @Override
    public HomePressenter getPresenter() {
        return new HomePressenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public <T> void getHome(T t) {
        HomeBannerBean bannerBean = (HomeBannerBean) t;
        if (t != null) {
            //banner数据
            banner.clear();
            banner.addAll(bannerBean.getData().getAdvList());
            lanGeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public <T> void getHomeCaregory(T t) {//首页一级列表
        HomeCaregoryBean homeCaregoryBean = (HomeCaregoryBean) t;
        if (t != null) {
            List<HomeCaregoryBean.DataBean.CourseCategoryListBean> courseCategoryList = homeCaregoryBean.getData().getCourseCategoryList();
            courseCategoryListBeans.clear();
            courseCategoryListBeans.addAll(courseCategoryList);
            Log.i("TAG","courseCategoryListBeans数量"+courseCategoryListBeans.size());
        }
        caregoryAdap.notifyDataSetChanged();
    }


    private void initAddAdapter() {
        adapter = new DelegateAdapter(layoutManager, false);
        adapter.addAdapter(lanGeAdapter);
        adapter.addAdapter(lanGetowAdapter);
        adapter.addAdapter(caregoryAdap);
    }

    private void initRecyclerViewSet() {
        mHomeRecycler.setLayoutManager(layoutManager);
        mHomeRecycler.setAdapter(adapter);
    }


    @Override
    public void getno(String str_no) {

    }

}