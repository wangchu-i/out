package com.bawei.wangchu10292;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.adapter.MyPageAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.fragment.BeiJing_Fragment;
import com.bawei.fragment.Center_Fragment;
import com.bawei.fragment.Left_Fragment;
import com.bawei.fragment.Right_Fragment;
import com.bawei.fragment.Zongzai_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager view_pager;
    private TabLayout tabLayout;
    private List<Fragment> fList = new ArrayList<>();
    private List<String> sList = new ArrayList<>();
    private MyPageAdapter adapter;

    @Override
    protected void initData() {
        //添加fragment
        fList.add(new Left_Fragment());
        fList.add(new Center_Fragment());
        fList.add(new Right_Fragment());
        fList.add(new Zongzai_Fragment());
        fList.add(new BeiJing_Fragment());
        //添加信息
        sList.add("最新");
        sList.add("婆媳");
        sList.add("房产");
        sList.add("仲裁");
        sList.add("北京");
        //设置适配器
        adapter = new MyPageAdapter(getSupportFragmentManager(),fList,sList);
        view_pager.setAdapter(adapter);
        //添加联动
        tabLayout.setupWithViewPager(view_pager);
    }

    @Override
    protected void initView() {
        //初始化控件
        view_pager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tabLayout);
    }

    @Override
    public int init() {
        return R.layout.activity_main;
    }
}
