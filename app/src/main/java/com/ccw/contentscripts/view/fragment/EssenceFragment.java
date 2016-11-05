package com.ccw.contentscripts.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ccw.contentscripts.BaseFragment;
import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.bean.EssenceBean;
import com.ccw.contentscripts.presenter.EssencePresenter;
import com.ccw.contentscripts.view.IShowEssence;
import com.ccw.contentscripts.view.adapter.EssenceAdapter;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class EssenceFragment extends BaseFragment implements IShowEssence{
    private ImageView pic;
    private TextView title;
    private ListView lv;

    private String pic_url;
    private EssencePresenter presenter = new EssencePresenter(this);

    private List<EssenceBean> mList;
    private Handler mHandler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            EssenceAdapter adapter = new EssenceAdapter(mList,getActivity());
            lv.setAdapter(adapter);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.essence_layout, container, false);
        initView(view);
        presenter.start();
        return view;
    }

    private void initView(View view) {
        pic = ((ImageView) view.findViewById(R.id.pic));
        title = ((TextView) view.findViewById(R.id.title));
        lv = ((ListView) view.findViewById(R.id.lv));
    }

    @Override
    public void setList(List<EssenceBean> list) {
        mList = list;
        mHandler.sendEmptyMessage(0);
    }
}
