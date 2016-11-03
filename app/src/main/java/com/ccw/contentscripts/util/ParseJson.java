package com.ccw.contentscripts.util;

import com.ccw.contentscripts.model.bean.ScriptsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class ParseJson {

    public static List<ScriptsBean> parseJson1(String json) {
        List<ScriptsBean> list = new ArrayList<>();
        try {
            JSONArray data = new JSONObject(json).getJSONObject("data").getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject jo = data.getJSONObject(i);
                if (jo.has("group")) {
                    JSONObject group = jo.getJSONObject("group");
                    String label = group.getString("status_desc");
                    String avatar_url = group.getJSONObject("user").getString("avatar_url");
                    String name = group.getJSONObject("user").getString("name");
                    String category_name = group.getString("category_name");
                    String content = group.getString("content");
                    int digg_count = group.getInt("digg_count");
                    int bury_count = group.getInt("bury_count");
                    int comment_count = group.getInt("comment_count");
                    int share_count = group.getInt("share_count");
                    ScriptsBean bean = new ScriptsBean(label, avatar_url, name, content, category_name, digg_count,
                            bury_count, comment_count, share_count);
                    list.add(bean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
