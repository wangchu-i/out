package com.bawei.lainxi001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.bean.News;
import com.bawei.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private GridView grid_view;
    private String url="http://blog.zhaoliang5156.cn/api/news/lawyer.json";
    private List<News.ListdataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void initData() {
        myAdapter = new MyAdapter(list, MainActivity.this);
        grid_view.setAdapter(myAdapter);
    }

    @Override
    protected void initView() {
        grid_view=findViewById(R.id.grid_view);
    }

    @Override
    public int init() {
        return R.layout.activity_main;
    }
}
