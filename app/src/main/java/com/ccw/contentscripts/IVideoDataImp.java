package com.ccw.contentscripts;

import com.ccw.contentscripts.model.IVideoData;
import com.ccw.contentscripts.model.OnDataLoad4Listener;
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

public class IVideoDataImp implements IVideoData{
    @Override
    public void getData(String path, final OnDataLoad4Listener onDataLoadListener) {
        final Request request = new Request.Builder()
                .url(path)
                .build();
        NetUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoadListener.onLoadFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                onDataLoadListener.onLoadSuccess(ParseJson.parse4Json(response.body().string()));
            }
        });
    }
}
