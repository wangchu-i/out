package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.News;
import com.bawei.lainxi001.R;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/11/1
 *@Time:19:56
 *@Description:${DESCRIPTION}
 **/
public class MyAdapter extends BaseAdapter {
    private List<News.ListdataBean> list;
    private Context context;

    public MyAdapter(List<News.ListdataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHandler handler;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.li1,null);
            handler=new ViewHandler();
            handler.text_a=convertView.findViewById(R.id.text_a);
            handler.img_a=convertView.findViewById(R.id.img_a);
            convertView.setTag(handler);
        }else {
            handler= (ViewHandler) convertView.getTag();
        }
        handler.text_a.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getAvatar()).into(handler.img_a);
        return convertView;
    }
    class ViewHandler{
        private TextView text_a;
        private ImageView img_a;
    }
}
