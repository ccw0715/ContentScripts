package com.ccw.contentscripts.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccw.contentscripts.BaseFragment;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class RecommendFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setText("推荐");
        return tv;
    }
}