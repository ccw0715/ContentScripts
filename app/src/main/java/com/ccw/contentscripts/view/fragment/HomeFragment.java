package com.ccw.contentscripts.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.ccw.contentscripts.BaseFragment;
import com.ccw.contentscripts.R;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class HomeFragment extends BaseFragment {

    private ImageView mine;
    private ImageView write;
    private LinearLayout ll;
    private RadioGroup rg;

    private Fragment fragment;
    private Fragment currentFragment;

    private SelectionFragment selectionFragment = new SelectionFragment();
    private ConcernFragment concernFragment = new ConcernFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);
        initView(view);
        initFragment();
        return view;
    }

    private void initFragment() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.selection:
                        fragment = selectionFragment;
                        break;
                    case R.id.concern:
                        fragment = concernFragment;
                        break;
                }
                if(fragment.isAdded()){
                    getChildFragmentManager().beginTransaction().hide(currentFragment).show(fragment).commit();
                }else {
                    getChildFragmentManager().beginTransaction().hide(currentFragment).add(R.id.ll,fragment).commit();
                }
               currentFragment = fragment;
            }
        });
        currentFragment = new SelectionFragment();
        getChildFragmentManager().beginTransaction().add(R.id.ll,currentFragment).commit();
    }

    private void initView(View view) {
        mine = (ImageView) view.findViewById(R.id.mine);
        write = (ImageView) view.findViewById(R.id.write);
        rg = ((RadioGroup) view.findViewById(R.id.rg));
        ll = (LinearLayout) view.findViewById(R.id.ll);
    }
}