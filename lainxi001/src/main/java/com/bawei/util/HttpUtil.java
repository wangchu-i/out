package com.bawei.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *@auther:王楚
 *@Date: 2019/10/29
 **/
public class HttpUtil {
    //单例模式
    public static HttpUtil util;
    private HttpUtil(){};
    public static synchronized HttpUtil getInstance(){
        if (util==null){
            util=new HttpUtil();
        }
        return util;
    }
    //网络判断
    public boolean getNetState(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }
    public String getNetJson(String str){
        try {
            URL url = new URL(str);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            conn.connect();
            int code = conn.getResponseCode();
            if (code==200){
                InputStream stream = conn.getInputStream();
                String json = streamToJson(stream);
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String streamToJson(InputStream stream) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String temp="";
        StringBuilder builder = new StringBuilder();
        while ((temp=reader.readLine())!=null){
            builder.append(temp);
        }
        //关流
        reader.close();
        return builder.toString();
    }
}
