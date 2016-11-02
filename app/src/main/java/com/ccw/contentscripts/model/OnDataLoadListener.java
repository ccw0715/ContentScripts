package com.ccw.contentscripts.model;

import com.ccw.contentscripts.model.bean.ScriptsBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public interface OnDataLoadListener {
    void onLoadSuccess(List<ScriptsBean> list);

    void onLoadFailed(String errorMsg);

}
