package com.bawei.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.bawei.adapter.MyAdapter;
import com.bawei.auync.MyTask;
import com.bawei.base.BaseFragment;
import com.bawei.bean.News;
import com.bawei.util.HttpUtil;
import com.bawei.wangchu10292.Main2Activity;
import com.bawei.wangchu10292.R;
import com.bwei.xlistview.XlistView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/10/29
 *@Time:14:05
 *@Description:${DESCRIPTION}
 **/
public class Left_Fragment extends BaseFragment implements XlistView.IXListViewListener {
    private XlistView xListView;
    //分页
    private String url="http://blog.zhaoliang5156.cn/api/news/lawyer.json";
    private int i=1;
    private List<News.ListdataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (HttpUtil.getInstance().getNetState(getActivity())){
            initRes(i);
            xListView.setPullLoadEnable(true);
            xListView.setPullRefreshEnable(true);
            xListView.setXListViewListener(this);
            myAdapter = new MyAdapter(list,getActivity());
            xListView.setAdapter(myAdapter);
            //点击事件
            xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), Main2Activity.class);
                    intent.putExtra("url",list.get(position).getUrl());
                    startActivity(intent);
                }
            });
        }
    }

    private void initRes(int i) {
        new MyTask(new MyTask.MyBack() {
            @Override
            public void myBack(String s) {
                //打印
                Log.i("aaa", "myBack: "+s);
                //Gson解析
                Gson gson = new Gson();
                News news = gson.fromJson(s,News.class);
                List<News.ListdataBean> da= news.getListdata();
                list.addAll(da);
                //适配器刷新
                myAdapter.notifyDataSetChanged();
            }
        }).execute(url);
    }

    @Override
    protected void initView(View view) {
        xListView=view.findViewById(R.id.xListView);
    }

    @Override
    public int init() {
        return R.layout.left;
    }

    @Override
    public void onRefresh() {
        list.clear();
        initRes(i);
    }

    @Override
    public void onLoadMore() {
        initRes(i);
    }
}
