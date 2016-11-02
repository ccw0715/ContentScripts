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

    public static List<ScriptsBean> parseJson1(String json){
        List<ScriptsBean> list = new ArrayList<>();
        try {
            JSONArray data = new JSONObject(json).getJSONObject("data").getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
