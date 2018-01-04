package com.example.cwg;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        String flag = getIntent().getStringExtra("flag");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(flag);
    }
}
