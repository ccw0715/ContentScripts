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

public class IEssenceDataImp implements IEssenceData {
    @Override
    public void getList(String path, final OnDataLoad3Listener onDataLoad3Listener) {
        Request request = new Request.Builder()
                .url(path)
                .build();
        NetUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoad3Listener.onLoadFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                onDataLoad3Listener.onLoadSuccess(ParseJson.parse3Json(response.body().string()));
            }
        });
    }
}
