package com.ccw.contentscripts.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccw.contentscripts.BaseFragment;
import com.ccw.contentscripts.R;
import com.ccw.contentscripts.view.adapter.SelectionFgAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class SelectionFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager vp;
    private String title[] = new String[]{"直播", "推荐", "视频", "图片", "段子", "精华", "同城", "游戏"};
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selection_layout, container, false);
        initView(view);
        initTabLayout();
        return view;
    }

    private void initTabLayout() {
        list = new ArrayList<>();
        list.add(new LiveFragment());
        list.add(new RecommendFragment());
        list.add(new VideoFragment());
        list.add(new PictureFragment());
        list.add(new ScriptsFragment());
        list.add(new EssenceFragment());
        list.add(new CityFragment());
        list.add(new GameFragment());
        SelectionFgAdapter adapter = new SelectionFgAdapter(getChildFragmentManager(),title,list);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);

    }

    private void initView(View view) {
        tabLayout = ((TabLayout) view.findViewById(R.id.tabLayout));
        vp = ((ViewPager) view.findViewById(R.id.viewPager));
    }
}
