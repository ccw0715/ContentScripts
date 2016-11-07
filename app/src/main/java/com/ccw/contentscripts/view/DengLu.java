package com.ccw.contentscripts.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ccw.contentscripts.R;

public class DengLu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);

    }

    public void back(View view) {
        overridePendingTransition(R.anim.exit,R.anim.enter);
        this.finish();
    }
}
