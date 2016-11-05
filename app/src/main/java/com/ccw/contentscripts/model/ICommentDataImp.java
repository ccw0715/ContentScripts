package com.ccw.contentscripts.model;

import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.util.ParseJson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public class ICommentDataImp implements ICommentData {
    @Override
    public void getData(String path, final OnDataLoad2Listener onDataLoadListener) {
        Request request =new Request.Builder()
                .url(path)
                .build();
        NetUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoadListener.onLoadFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                onDataLoadListener.onLoadSuccess(ParseJson.parse2Json(response.body().string()));
            }
        });
    }
}
