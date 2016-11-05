package com.ccw.contentscripts.model;

import com.ccw.contentscripts.model.bean.VideoBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public interface OnDataLoad4Listener {
    void onLoadSuccess(List<VideoBean> list);

    void onLoadFailed(String errorMsg);

}
