package com.example.wangtao.animationdemo.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangtao on 2018/7/5.
 */

public class DetilsBean implements Parcelable {


    public String _id = "1";  //书id
    public String author = "1";  // 作者
    public String cover = "1";  //封面
    public String shortIntro = "1";  //简介
    public String title = "1";  //标题
    public String isPaid = "1"; //是否付费
    public String isfinish = "0"; //本书是否完结


    protected DetilsBean(Parcel in) {
        _id = in.readString();
        author = in.readString();
        cover = in.readString();
        shortIntro = in.readString();
        title = in.readString();
        isPaid = in.readString();
        isfinish = in.readString();
    }

    public static final Creator<DetilsBean> CREATOR = new Creator<DetilsBean>() {
        @Override
        public DetilsBean createFromParcel(Parcel in) {
            return new DetilsBean(in);
        }

        @Override
        public DetilsBean[] newArray(int size) {
            return new DetilsBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_id);
        parcel.writeString(author);
        parcel.writeString(cover);
        parcel.writeString(shortIntro);
        parcel.writeString(title);
        parcel.writeString(isPaid);
        parcel.writeString(isfinish);
    }
}
