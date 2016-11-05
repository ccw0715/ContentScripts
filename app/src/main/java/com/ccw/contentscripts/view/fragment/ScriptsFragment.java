package com.ccw.contentscripts.view.fragment;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ccw.contentscripts.BaseFragment;
import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.IScriptsData;
import com.ccw.contentscripts.model.IScriptsDataImp;
import com.ccw.contentscripts.model.OnDataLoadListener;
import com.ccw.contentscripts.model.bean.ScriptsBean;
import com.ccw.contentscripts.presenter.ScriptsPresenter;
import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.view.DetailsActivity;
import com.ccw.contentscripts.view.IShowScriptsView;
import com.ccw.contentscripts.view.adapter.MyAdapter;

import org.lenve.customshapeimageview.CustomShapeImageView;

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
    private CustomShapeImageView refresh;
    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            refresh.clearAnimation();
            adapter.notifyDataSetChanged();
            //停止下拉刷新动画
            srl.setRefreshing(false);
        }
    };
    private Animation animation;
    private RelativeLayout rl;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scripts_layout, container, false);
        initView(view);
        initAnimator();
        presenter.start();
        return view;
    }

    private void initView(View view) {
        srl = ((SwipeRefreshLayout) view.findViewById(R.id.srl));
        lv = ((ListView) view.findViewById(R.id.lv));
        refresh = ((CustomShapeImageView) view.findViewById(R.id.refresh));

    }

    @Override
    public void setList(List<ScriptsBean> list) {
        adapter = new MyAdapter(list,getActivity());
        lv.setAdapter(adapter);
        mList= list;
        initSrl();
        srl.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        //下拉刷新监听
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.startAnimation(animation);
                iScriptsData.getData(NetUtil.scriptsPath, onDataLoadListener);
            }
        });
    }

    private void initAnimator() {
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        //刷新点击事件
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh.startAnimation(animation);
                srl.setRefreshing(true);
                iScriptsData.getData(NetUtil.scriptsPath, onDataLoadListener);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                ScriptsBean bean = mList.get(position);
                intent.putExtra("bean",bean);
                intent.putExtra("flag","bean");
                startActivity(intent);
                //设置Activity转场动画
                getActivity().overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
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
