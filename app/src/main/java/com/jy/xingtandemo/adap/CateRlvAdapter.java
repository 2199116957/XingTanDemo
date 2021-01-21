package com.jy.xingtandemo.adap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.xingtandemo.R;
import com.jy.xingtandemo.bean.HomeCaregoryBean;

import java.util.ArrayList;

public class CateRlvAdapter extends RecyclerView.Adapter {
    private ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean> list;
    private ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean.SubListBean> subListBeans;
    private Context context;

    public CateRlvAdapter(ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean> list, ArrayList<HomeCaregoryBean.DataBean.CourseCategoryListBean.SubListBean> subListBeans, Context context) {
        this.list = list;
        this.subListBeans = subListBeans;
        this.context = context;
    }
    private  onClick onClick;

    public void setOnClick( onClick onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_cate_rlv, parent, false);
        return new CateRlvViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CateRlvViewHolder viewHolder = (CateRlvViewHolder) holder;
        viewHolder.btnCate.setText(subListBeans.get(position).getCategoryName());
        viewHolder.btnCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subListBeans.size();
    }
    private class CateRlvViewHolder extends RecyclerView.ViewHolder {
        Button btnCate;
        public CateRlvViewHolder(View view) {
            super(view);
            btnCate = view.findViewById(R.id.btn_cate);
        }
    }


    public interface onClick{
        void onClick(int position);
    }
}
