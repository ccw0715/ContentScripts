package com.ccw.contentscripts.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.ccw.contentscripts.BaseFragment;
import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.IScriptsData;
import com.ccw.contentscripts.model.IScriptsDataImp;
import com.ccw.contentscripts.model.OnDataLoadListener;
import com.ccw.contentscripts.model.bean.ScriptsBean;
import com.ccw.contentscripts.presenter.ScriptsPresenter;
import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.view.IShowScriptsView;
import com.ccw.contentscripts.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class ScriptsFragment extends BaseFragment implements IShowScriptsView {
    private ListView lv;
    private ScriptsPresenter presenter = new ScriptsPresenter(this);
    private SwipeRefreshLayout srl;
    private OnDataLoadListener onDataLoadListener;
    private MyAdapter adapter;
    private IScriptsData iScriptsData = new IScriptsDataImp();
    private List<ScriptsBean> mList = new ArrayList<>();

    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            adapter.notifyDataSetChanged();
            //停止下拉刷新动画
            srl.setRefreshing(false);
        }
    };
    private ImageView refresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scripts_layout, container, false);
        initView(view);
        presenter.start();
        return view;
    }

    private void initView(View view) {
        srl = ((SwipeRefreshLayout) view.findViewById(R.id.srl));
        lv = ((ListView) view.findViewById(R.id.lv));
        refresh = ((ImageView) view.findViewById(R.id.refresh));
    }

    @Override
    public void setList(List<ScriptsBean> list) {
        adapter = new MyAdapter(list,getActivity());
        lv.setAdapter(adapter);
        mList= list;
        initSrl();
        initAnimator();
        srl.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        //下拉刷新监听
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                iScriptsData.getData(NetUtil.scriptsPath, onDataLoadListener);
            }
        });
    }

    private void initAnimator() {
    }

    private void initSrl() {
        onDataLoadListener = new OnDataLoadListener() {
            @Override
            public void onLoadSuccess(List<ScriptsBean> list) {
                if(mList.size()>21){
                    for (int i = 20; i < mList.size(); i++) {
                        mList.remove(i);
                    }
                }
                mList.addAll(0,list);
                mHandler.sendEmptyMessage(0);
            }
            @Override
            public void onLoadFailed(String errorMsg) {

            }
        };
    }
}
