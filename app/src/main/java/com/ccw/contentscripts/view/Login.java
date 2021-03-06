package com.ccw.contentscripts.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ccw.contentscripts.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        startActivity(new Intent(this,DengLu.class));
        overridePendingTransition(R.anim.enter,R.anim.exit);
    }

    public void back(View view) {
        overridePendingTransition(R.anim.exit,R.anim.enter);
        this.finish();
    }
}