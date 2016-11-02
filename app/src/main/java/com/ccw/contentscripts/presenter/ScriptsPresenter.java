package com.ccw.contentscripts.presenter;

import android.os.Handler;

import com.ccw.contentscripts.IBasePresenter;
import com.ccw.contentscripts.model.IScriptsData;
import com.ccw.contentscripts.model.IScriptsDataImp;
import com.ccw.contentscripts.model.OnDataLoadListener;
import com.ccw.contentscripts.model.bean.ScriptsBean;
import com.ccw.contentscripts.view.IShowScriptsView;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class ScriptsPresenter implements IBasePresenter {

    private IScriptsData iScriptsData;
    private IShowScriptsView iShowScriptsView;

    private Handler mHandler = new Handler();

    public ScriptsPresenter(IShowScriptsView iShowScriptsView) {
        this.iShowScriptsView = iShowScriptsView;
        iScriptsData = new IScriptsDataImp();
    }

    @Override
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                iScriptsData.getData(new OnDataLoadListener() {
                    @Override
                    public void onLoadSuccess(final List<ScriptsBean> list) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                iShowScriptsView.setList(list);
                            }
                        });
                    }

                    @Override
                    public void onLoadFailed(String errorMsg) {

                    }
                });
            }
        }).start();

    }
}
