package com.example.wangtao.animationdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wangtao.animationdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxJavaActivity extends AppCompatActivity {

    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.bt_end)
    Button btEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_start, R.id.bt_end})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
//                EasyHttp.get().accessToken(true)
                break;
        }
    }
}
