package com.ccw.contentscripts.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class NetUtil {

    public static String scriptsPath = "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-102&message_cursor=-1&am_longitude=113.340798&am_latitude=23.176681&am_city=广州市&am_loc_time=1478077356716&count=30&min_time=1478078258&screen_width=1080&iid=5865337185&device_id=31850044699&ac=wifi&channel=store_qq_llq&aid=7&app_name=joke_essay&version_code=560&version_name=5.6.0&device_platform=android&ssmix=a&device_type=m1+note&device_brand=Meizu&os_api=22&os_version=5.1&uuid=867031026027265&openudid=511cfcba4bb3e3d3&manifest_version_code=560&resolution=1080*1920&dpi=480&update_version_code=5603";
    public static String commentPath = "http://isub.snssdk.com/neihan/comments/?group_id=%d&count=40&offset=0";
    public static String essencePath = "http://toutiao.com/ma/?media_id=5234320301&count=10&max_behot_time=0&as=A10548F1FCA816D&cp=581C0881865D1E1&callback=jsonp1&csrfmiddlewaretoken=undefined&_=%d";
    public static String videoPath="http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-104&message_cursor=-1&am_longitude=113.340751&am_latitude=23.176658&am_city=广州市&am_loc_time=1478311882391&count=30&min_time=1478244355&screen_width=1080&iid=5865337185&device_id=31850044699&ac=wifi&channel=store_qq_llq&aid=7&app_name=joke_essay&version_code=560&version_name=5.6.0&device_platform=android&ssmix=a&device_type=m1+note&device_brand=Meizu&os_api=22&os_version=5.1&uuid=867031026027265&openudid=511cfcba4bb3e3d3&manifest_version_code=560&resolution=1080*1920&dpi=480&update_version_code=5603";
//    public static String
//    public static String
//    public static String
//    public static String


    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .build();

    public static OkHttpClient getClient() {
        return client;
    }
}
