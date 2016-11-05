package com.ccw.contentscripts.presenter;

import android.os.Handler;

import com.ccw.contentscripts.IBasePresenter;
import com.ccw.contentscripts.IVideoDataImp;
import com.ccw.contentscripts.model.IVideoData;
import com.ccw.contentscripts.model.OnDataLoad4Listener;
import com.ccw.contentscripts.model.bean.VideoBean;
import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.view.IShowVideo;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/5 0005.
 */

public class VideoPresenter implements IBasePresenter{
    private IShowVideo iShowVideo;
    private IVideoData iVideoData;

    private Handler mHandler= new Handler();
    public VideoPresenter(IShowVideo iShowVideo) {
        this.iShowVideo = iShowVideo;
        iVideoData = new IVideoDataImp();
    }

    @Override
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iVideoData.getData(NetUtil.videoPath, new OnDataLoad4Listener() {
                            @Override
                            public void onLoadSuccess(List<VideoBean> list) {
                                iShowVideo.setList(list);
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
