package com.jy.xingtandemo.adap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jy.xingtandemo.R;
import com.jy.xingtandemo.bean.HomeCaregoryBean;
import com.jy.xingtandemo.bean.HomeStairImageBean;

import java.util.ArrayList;
import java.util.List;

public class CaregoryAdap extends DelegateAdapter.Adapter {
    private GridLayoutHelper singleLayoutHelper;
    private ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean> list;
    private LinearLayoutHelper linearLayoutHelper;
    private Context context;

    public CaregoryAdap(GridLayoutHelper singleLayoutHelper, ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean> list, LinearLayoutHelper linearLayoutHelper, Context context) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.list = list;
        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    OnItemClick onItemClick;

    public interface OnItemClick {
        void setOnClickTitle(int onePostion, int twoPostion, ArrayList<HomeStairImageBean.DataBean.CourseGradeListBean>
                listBeans, HomeStairImageAdap homeStairImageAdap);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_aregory, null, false);
        return new CaregoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CaregoryViewHolder caregoryViewHolder = (CaregoryViewHolder) holder;
        HomeCaregoryBean.DataBean.CourseCategoryListBean courseCategoryListBean = list.get(position);
        caregoryViewHolder.mHomeTitleCategoryName.setText(courseCategoryListBean.getCategoryName());
        caregoryViewHolder.mHomeRecyclerCategoryName.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));

        ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean.SubListBean> subList = (ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean.SubListBean>) list.get(position).getSubList();
        CateRlvAdapter cateRlvAdapter = new CateRlvAdapter(list, subList, context);
        caregoryViewHolder.mHomeRecyclerCategoryName.setAdapter(cateRlvAdapter);

        caregoryViewHolder.mHomeRecyclerSubList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        ArrayList<HomeStairImageBean.DataBean.CourseGradeListBean> courseGradeListBeans = new ArrayList<>();
        HomeStairImageAdap homeStairImageAdap = new HomeStairImageAdap(context, courseGradeListBeans);
        caregoryViewHolder.mHomeRecyclerSubList.setAdapter(homeStairImageAdap);

        cateRlvAdapter.setOnClick(new CateRlvAdapter.onClick() {
            @Override
            public void onClick(int pos) {
                onItemClick.setOnClickTitle(position, pos, courseGradeListBeans, homeStairImageAdap);
            }
        });
        onItemClick.setOnClickTitle(position,0,courseGradeListBeans,homeStairImageAdap);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class CaregoryViewHolder extends RecyclerView.ViewHolder {
        private TextView mHomeTitleCategoryName;
        private TextView mHomeMore;
        private RecyclerView mHomeRecyclerSubList;
        private RecyclerView mHomeRecyclerCategoryName;

        public CaregoryViewHolder(View view) {
            super(view);
            mHomeTitleCategoryName = view.findViewById(R.id.home_title_categoryName);
            mHomeMore = view.findViewById(R.id.home_more);
            mHomeRecyclerCategoryName = view.findViewById(R.id.home_recycler_categoryName);
            mHomeRecyclerSubList = view.findViewById(R.id.home_recycler_subList);
        }
    }


}
