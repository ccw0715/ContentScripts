package com.ccw.contentscripts.presenter;

import android.os.Handler;

import com.ccw.contentscripts.IBasePresenter;
import com.ccw.contentscripts.model.ICommentData;
import com.ccw.contentscripts.model.ICommentDataImp;
import com.ccw.contentscripts.model.OnDataLoad2Listener;
import com.ccw.contentscripts.model.bean.CommentBean;
import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.view.DetailsActivity;
import com.ccw.contentscripts.view.IShowComment;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public class CommentPresenter implements IBasePresenter {
    private IShowComment iShowComment;
    private ICommentData iCommentData;
    private Handler mHandler = new Handler();

    public CommentPresenter(IShowComment iShowComment) {
        this.iShowComment = iShowComment;
        iCommentData = new ICommentDataImp();
    }

    @Override
    public void start() {
        final String path = String.format(NetUtil.commentPath , DetailsActivity.id);
        new Thread(new Runnable() {
            @Override
            public void run() {
                iCommentData.getData(path, new OnDataLoad2Listener() {
                    @Override
                    public void onLoadSuccess(final List<CommentBean> list) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                iShowComment.setList(list);
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
