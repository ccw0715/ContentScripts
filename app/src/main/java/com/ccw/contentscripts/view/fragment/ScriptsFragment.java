package com.ccw.contentscripts.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ccw.contentscripts.BaseFragment;
import com.ccw.contentscripts.R;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class ScriptsFragment extends BaseFragment {
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scripts_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv = ((ListView) view.findViewById(R.id.lv));
    }
}
