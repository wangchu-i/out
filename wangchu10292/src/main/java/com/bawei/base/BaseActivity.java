package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@auther:王楚
 *@Date: 2019/10/29
 *@Time:14:01
 *@Description:${DESCRIPTION}
 **/
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(init());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    public abstract int init();
}
