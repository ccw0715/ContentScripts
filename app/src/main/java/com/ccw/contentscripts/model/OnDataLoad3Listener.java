package com.ccw.contentscripts.model;

import com.ccw.contentscripts.model.bean.EssenceBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public interface OnDataLoad3Listener {
    void onLoadSuccess(List<EssenceBean> list);

    void onLoadFailed(String errorMsg);

}
