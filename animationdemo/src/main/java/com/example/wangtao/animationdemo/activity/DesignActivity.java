package com.example.wangtao.animationdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wangtao.animationdemo.R;

import butterknife.ButterKnife;

public class DesignActivity extends AppCompatActivity {

//    @BindView(R.id.recyclerView)
//    RecyclerView recyclerView;
//    @BindView(R.id.appBarLayout)
//    AppBarLayout appBarLayout;
//    @BindView(R.id.tv1)
//    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new DesignAdapter(this));
//        setAppBar();
    }

    private void setAppBar() {
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                int height = tv1.getHeight();
//                int minHeight = tv1.getMinHeight();
//                float fraction = verticalOffset / (float) (minHeight - height);
//                tv1.setAlpha(1 - fraction);
//            }
//        });
    }
}
