package com.ccw.contentscripts.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import com.ccw.contentscripts.BaseFragment;
import com.ccw.contentscripts.IVideoDataImp;
import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.IVideoData;
import com.ccw.contentscripts.model.OnDataLoad4Listener;
import com.ccw.contentscripts.model.bean.VideoBean;
import com.ccw.contentscripts.presenter.VideoPresenter;
import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.view.IShowVideo;
import com.ccw.contentscripts.view.adapter.VideoAdapter;

import org.lenve.customshapeimageview.CustomShapeImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class VideoFragment extends BaseFragment implements IShowVideo{
    private VideoPresenter presenter = new VideoPresenter(this);
    private ListView lv;
    private SwipeRefreshLayout srl;
    private List<VideoBean> mList = new ArrayList<>();
    private CustomShapeImageView refresh;
    private Animation animation;
    private IVideoData iVideoData = new IVideoDataImp();
    private OnDataLoad4Listener onDataLoad4Listener;
    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    adapter = new VideoAdapter(mList,getActivity());
                    lv.setAdapter(adapter);
                    break;
                case 1:
                    refresh.clearAnimation();
                    adapter.notifyDataSetChanged();
                    //停止下拉刷新动画
                    srl.setRefreshing(false);
                    break;
            }
        }
    };
    private VideoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_layout, container, false);
        initView(view);
        initAnimator();
        presenter.start();
        return view;
    }

    private void initAnimator() {
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        //刷新点击事件
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh.startAnimation(animation);
                srl.setRefreshing(true);
                iVideoData.getData(NetUtil.videoPath,onDataLoad4Listener);
            }
        });
    }

    private void initView(View view) {
        srl = ((SwipeRefreshLayout) view.findViewById(R.id.srl));
        lv = ((ListView) view.findViewById(R.id.lv));
        refresh = ((CustomShapeImageView) view.findViewById(R.id.refresh));
    }

    @Override
    public void setList(List<VideoBean> list) {

        mList = list;
        mHandler.sendEmptyMessage(0);
        initSrl();
        srl.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        //下拉刷新监听
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.startAnimation(animation);
                iVideoData.getData(NetUtil.scriptsPath, onDataLoad4Listener);
            }
        });
        mHandler.sendEmptyMessage(1);
    }

    private void initSrl() {
        onDataLoad4Listener = new OnDataLoad4Listener() {
            @Override
            public void onLoadSuccess(List<VideoBean> list) {
                if(mList.size()>21){
                    for (int i = 20; i < mList.size(); i++) {
                        mList.remove(i);
                    }
                }
                mList.addAll(0,list);
                mHandler.sendEmptyMessage(1);
            }
            @Override
            public void onLoadFailed(String errorMsg) {

            }
        };
    }

}
