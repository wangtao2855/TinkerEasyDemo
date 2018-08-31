package com.example.wangtao.animationdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangtao.animationdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangtao on 2018/5/30.
 */

public class HorRecyclerViewAdapter extends RecyclerView.Adapter {

    private String[] strings = new String[]{"不限", "男生", "女生", "漫画", "不限", "男生", "女生", "漫画", "男生", "不限", "搜索", "问问", "说我", "是是"};
    private Context context;

    public HorRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new TextViewHolder(LayoutInflater.from(context).inflate(R.layout.textview, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TextViewHolder) holder).setData(position);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview1)
        TextView textview1;

        public TextViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this,inflate);
        }

        public void setData(int position) {
            textview1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (textview1.isSelected()){
                        textview1.setSelected(false);
                    }else {
                        textview1.setSelected(true);
                    }
                }
            });
        }
    }
}
