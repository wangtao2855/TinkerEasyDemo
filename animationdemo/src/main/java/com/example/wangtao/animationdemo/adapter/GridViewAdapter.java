//package com.example.wangtao.animationdemo.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.wangtao.animationdemo.R;
//
//import org.w3c.dom.Text;
//
//import java.util.List;
//
///**
// * Created by wangtao on 2018/4/18.
// */
//
//public class GridViewAdapter extends RecyclerView.Adapter {
//
//    private Context context;
//    private final int Type1 = 99;
//    private final int Type2 = 100;
//    private RecyclerView recyclerView;
//
//    public GridViewAdapter(RecyclerView recyclerView, Context context) {
//        this.context = context;
//        this.recyclerView = recyclerView;
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        RecyclerView.ViewHolder holder = null;
//        holder = new GridViewAllHolder(LayoutInflater.from(context).inflate(R.layout.textview_all, null));
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ((GridViewAllHolder) holder).setData(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return 50;
//    }
//
//
//    private class GridViewAllHolder extends RecyclerView.ViewHolder {
//        private int data;
//        private final TextView viewById;
//
//        public GridViewAllHolder(View inflate) {
//            super(inflate);
//            viewById = inflate.findViewById(R.id.textviewall);
//        }
//
//        public void setData(int data) {
//            this.data = data;
//        }
//    }
//}
