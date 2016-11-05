package com.ccw.contentscripts.util;

import android.util.Log;

import com.ccw.contentscripts.model.bean.CommentBean;
import com.ccw.contentscripts.model.bean.EssenceBean;
import com.ccw.contentscripts.model.bean.ScriptsBean;
import com.ccw.contentscripts.model.bean.VideoBean;

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
                    long id_str = group.getLong("id_str");
                    ScriptsBean bean = new ScriptsBean(label, avatar_url, name, content, category_name, digg_count,
                            bury_count, comment_count, share_count,id_str);
                    list.add(bean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<CommentBean> parse2Json(String json){
        List<CommentBean> list = new ArrayList<>();
        try {
            int number = new JSONObject(json).getInt("total_number");
            if (number == 0) {

            }else {
                JSONArray data = new JSONObject(json).getJSONObject("data").getJSONArray("recent_comments");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject jo = data.getJSONObject(i);
                    String avatar_url = jo.getString("avatar_url");
                    String user_name = jo.getString("user_name");
                    int digg_count = jo.getInt("digg_count");
                    String text = jo.getString("text");
                    CommentBean bean = new CommentBean(avatar_url,user_name,digg_count,text);
                    list.add(bean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<EssenceBean> parse3Json(String json){
        List<EssenceBean> list = new ArrayList<>();
        String substring = json.substring(7, json.length() - 1);
        Log.d("哈哈日记", "parse3Json: "+substring);
        try {
            JSONArray data = new JSONObject(substring).getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject jo = data.getJSONObject(i);
                String keywords = jo.getString("keywords");
                String title = jo.getString("title");
                String image_url = jo.getString("image_url");
                EssenceBean bean = new EssenceBean();
                list.add(bean);
                Log.d("哈哈日记", "parse3Json: "+list.size());
                Log.d("哈哈日记", "parse3Json: "+bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<VideoBean> parse4Json(String json) {
        List<VideoBean> list = new ArrayList<>();
        JSONArray data = null;
        try {
            data = new JSONObject(json).getJSONObject("data").getJSONArray("data");
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
                    long id_str = group.getLong("id_str");
                    String mp4_url = group.getString("mp4_url");
                    int indexOf = mp4_url.indexOf("&");
                    String video_url = mp4_url.substring(0, indexOf);
                    String pic_url = group.getJSONObject("large_cover").getJSONArray("url_list").getJSONObject(0).getString("url");
                    int video_height = group.getInt("video_height");
                    VideoBean bean = new VideoBean(label,avatar_url,name,content,category_name,
                            digg_count,bury_count,comment_count,share_count,id_str,video_url,pic_url, video_height);
                    list.add(bean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
