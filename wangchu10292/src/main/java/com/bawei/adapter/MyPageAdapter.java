package com.bawei.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/10/29
 *@Time:14:06
 *@Description:${DESCRIPTION}
 **/
public class MyPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fList;
    private List<String> sList ;

    public MyPageAdapter(FragmentManager fm, List<Fragment> fList, List<String> sList) {
        super(fm);
        this.fList = fList;
        this.sList = sList;
    }

    @Override
    public Fragment getItem(int i) {
        return fList.get(i);
    }

    @Override
    public int getCount() {
        return fList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return sList.get(position);
    }
}
