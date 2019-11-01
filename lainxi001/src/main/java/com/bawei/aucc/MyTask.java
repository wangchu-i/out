package com.bawei.aucc;

import android.os.AsyncTask;

import com.bawei.util.HttpUtil;

/*
 *@auther:王楚
 *@Date: 2019/10/29
 *@Time:14:13
 *@Description:${DESCRIPTION}
 **/
public class MyTask extends AsyncTask<String,Void,String> {
    private MyBack myBack;

    public MyTask(MyBack myBack) {
        this.myBack = myBack;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        myBack.myBack(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        String date = HttpUtil.getInstance().getNetJson(strings[0]);
        return date;
    }
    public interface MyBack{
        void myBack(String s);
    }
}
