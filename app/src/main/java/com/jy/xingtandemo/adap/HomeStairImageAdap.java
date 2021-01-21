package com.jy.xingtandemo.adap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jy.xingtandemo.R;
import com.jy.xingtandemo.bean.HomeStairImageBean;

import java.util.ArrayList;

public class HomeStairImageAdap extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeStairImageBean.DataBean.CourseGradeListBean> listBeans;

    public HomeStairImageAdap(Context context, ArrayList<HomeStairImageBean.DataBean.CourseGradeListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_home_stair, parent, false);
        return new StairImageViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StairImageViewHolder stairImageViewHolder = (StairImageViewHolder) holder;
        stairImageViewHolder.mItemTextStair.setText(listBeans.get(position).getGradeName());
        Glide.with(context).load(listBeans.get(position).getClassLogo()).into(stairImageViewHolder.mItemImageStair);


    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }
    private class StairImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView mItemImageStair;
        private TextView mItemTextStair;
        public StairImageViewHolder(View view) {
            super(view);
             mItemImageStair = view.findViewById(R.id.item_image_stair);
             mItemTextStair = view.findViewById(R.id.item_text_stair);
        }
    }
}
