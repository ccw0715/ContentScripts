package com.ccw.contentscripts.model;

import com.ccw.contentscripts.util.NetUtil;
import com.ccw.contentscripts.util.ParseJson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class IScriptsDataImp implements IScriptsData{

    @Override
    public void getData(final OnDataLoadListener onDataLoadListener) {
        Request request = new Request.Builder()
                .url(NetUtil.scriptsPath)
                .build();
        NetUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoadListener.onLoadFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                onDataLoadListener.onLoadSuccess(ParseJson.parseJson1(response.body().string()));
            }
        });
    }
}
