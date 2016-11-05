package com.ccw.contentscripts.model;

import com.ccw.contentscripts.model.bean.CommentBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public interface OnDataLoad2Listener {
    void onLoadSuccess(List<CommentBean> list);

    void onLoadFailed(String errorMsg);
}
