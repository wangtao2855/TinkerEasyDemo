package com.example.cwg;

import android.app.Application;
import android.support.annotation.NonNull;

import com.antfortune.freeline.FreelineCore;

/**
 * Created by wangtao on 2017/12/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FreelineCore.init(this);

    }
}
