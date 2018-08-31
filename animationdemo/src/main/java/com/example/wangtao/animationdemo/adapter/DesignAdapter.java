//package com.example.wangtao.animationdemo.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.wangtao.animationdemo.R;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
///**
// * Created by wangtao on 2018/8/20.
// */
//
//public class DesignAdapter extends RecyclerView.Adapter {
//
//    private Context mContext;
//
//    public DesignAdapter(Context context) {
//        this.mContext = context;
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        RecyclerView.ViewHolder holder = null;
//        holder = new DesignViewHolder(LayoutInflater.from(mContext).inflate(R.layout.textview_all, null));
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ((DesignViewHolder) holder).setData(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return 30;
//    }
//
//    class DesignViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.textviewall)
//        TextView textviewall;
//
//        public DesignViewHolder(View inflate) {
//            super(inflate);
//            ButterKnife.bind(this, inflate);
//        }
//
//        public void setData(int position) {
//            textviewall.setText("我不是黄蓉，我不会武功--" + position);
//        }
//    }
//}
