package com.ccw.contentscripts.presenter;

import android.os.Handler;
import android.util.Log;

import com.ccw.contentscripts.IBasePresenter;
import com.ccw.contentscripts.model.IEssenceData;
import com.ccw.contentscripts.model.IEssenceDataImp;
import com.ccw.contentscripts.model.OnDataLoad3Listener;
import com.ccw.contentscripts.model.bean.EssenceBean;
import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.view.IShowEssence;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public class EssencePresenter implements IBasePresenter {
    private IShowEssence iShowEssence;
    private IEssenceData iEssenceData;

    private Handler mHandler= new Handler();
    public EssencePresenter(IShowEssence iShowEssence) {
        this.iShowEssence = iShowEssence;
        iEssenceData = new IEssenceDataImp();
    }

    @Override
    public void start() {
        long l = System.currentTimeMillis();
        Log.d("哈哈日记", "start: "+l);
        final String s = String.format(NetUtil.essencePath, l);
        Log.d("哈哈日记", "start: "+s);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                       iEssenceData.getList(s, new OnDataLoad3Listener() {
                           @Override
                           public void onLoadSuccess(List<EssenceBean> list) {
                               iShowEssence.setList(list);
                           }

                           @Override
                           public void onLoadFailed(String errorMsg) {

                           }
                       });
                    }
                });
            }
        }).start();

    }
}
