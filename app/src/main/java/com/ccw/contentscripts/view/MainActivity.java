package com.ccw.contentscripts.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ccw.contentscripts.BaseActivity;
import com.ccw.contentscripts.R;
import com.ccw.contentscripts.view.fragment.DiscoveryFragment;
import com.ccw.contentscripts.view.fragment.FreshFragment;
import com.ccw.contentscripts.view.fragment.HomeFragment;
import com.ccw.contentscripts.view.fragment.MsgFragment;

public class MainActivity extends BaseActivity{

    private RadioGroup rg;
    private RadioButton home;
    private RadioButton discovery;
    private RadioButton fresh;
    private RadioButton msg;
    private LinearLayout ll;

    private Fragment fragment;
    private Fragment currentFragment;

    private HomeFragment homeFragment = new HomeFragment();
    private DiscoveryFragment discoveryFragment = new DiscoveryFragment();
    private FreshFragment freshFragment = new FreshFragment();
    private MsgFragment msgFragment = new MsgFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //RadioGroup点击事件
        initClick();

    }

    private void initClick() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                home.setTextColor(getResources().getColor(R.color.black));
                discovery.setTextColor(getResources().getColor(R.color.black));
                fresh.setTextColor(getResources().getColor(R.color.black));
                msg.setTextColor(getResources().getColor(R.color.black));
                switch (checkedId) {
                    case R.id.home:
                        home.setTextColor(getResources().getColor(R.color.brown));
                        fragment = homeFragment;
                        break;
                    case R.id.discovery:
                        discovery.setTextColor(getResources().getColor(R.color.brown));
                        fragment = discoveryFragment;
                        break;
                    case R.id.fresh:
                        fresh.setTextColor(getResources().getColor(R.color.brown));
                        fragment = freshFragment;
                        break;
                    case R.id.msg:
                        msg.setTextColor(getResources().getColor(R.color.brown));
                        fragment = msgFragment;
                        break;
                }
                if (fragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragment).commit();
                }else {
                    getSupportFragmentManager().beginTransaction().hide(currentFragment).add(R.id.ll,fragment).commit();
                }
                currentFragment = fragment;
            }
        });
        currentFragment = new HomeFragment();
        home.setTextColor(getResources().getColor(R.color.brown));
        getSupportFragmentManager().beginTransaction().add(R.id.ll,currentFragment).commit();
    }

    private void initView() {
        rg = ((RadioGroup) findViewById(R.id.rg));
        home = ((RadioButton) findViewById(R.id.home));
        discovery = ((RadioButton) findViewById(R.id.discovery));
        fresh = ((RadioButton) findViewById(R.id.fresh));
        msg = ((RadioButton) findViewById(R.id.msg));
        ll = ((LinearLayout) findViewById(R.id.ll));

        Drawable drawable1 = getResources().getDrawable(R.drawable.home_bg);
        drawable1.setBounds(0,20,90,100);
        home.setCompoundDrawables(null,drawable1,null,null);

        Drawable drawable2 = getResources().getDrawable(R.drawable.discovery_bg);
        drawable2.setBounds(0,20,90,100);
        discovery.setCompoundDrawables(null,drawable2,null,null);

        Drawable drawable3 = getResources().getDrawable(R.drawable.fresh_bg);
        drawable3.setBounds(0,20,90,100);
        fresh.setCompoundDrawables(null,drawable3,null,null);

        Drawable drawable4 = getResources().getDrawable(R.drawable.msg_bg);
        drawable4.setBounds(0,20,90,100);
        msg.setCompoundDrawables(null,drawable4,null,null);
    }
}
