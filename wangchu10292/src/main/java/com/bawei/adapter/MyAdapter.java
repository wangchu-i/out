package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.News;
import com.bawei.wangchu10292.R;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/10/29
 *@Time:14:21
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
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHandler handler;
        ViewHandler2 handler2;
        if (getItemViewType(position)==1){
            if (convertView==null){
                convertView=View.inflate(context, R.layout.list1,null);
                handler=new ViewHandler();
                handler.text_a=convertView.findViewById(R.id.text_a);
                handler.text_b=convertView.findViewById(R.id.text_b);
                handler.img_a=convertView.findViewById(R.id.img_a);
                convertView.setTag(handler);
            }else {
                handler= (ViewHandler) convertView.getTag();
            }
            handler.text_a.setText(list.get(position).getName());
            handler.text_b.setText(list.get(position).getInfo());
            Glide.with(context).load(list.get(position).getAvatar()).into(handler.img_a);
        }else if (getItemViewType(position)==2){
            if (convertView==null){
                convertView=View.inflate(context, R.layout.list2,null);
                handler2=new ViewHandler2();
                handler2.text_c=convertView.findViewById(R.id.text_c);
                handler2.text_d=convertView.findViewById(R.id.text_d);
                handler2.img_b=convertView.findViewById(R.id.img_b);
                convertView.setTag(handler2);
            }else {
                handler2= (ViewHandler2) convertView.getTag();
            }
            handler2.text_c.setText(list.get(position).getName());
            handler2.text_d.setText(list.get(position).getInfo());
            Glide.with(context).load(list.get(position).getAvatar()).into(handler2.img_b);
        }
        return convertView;
    }
    class ViewHandler{
        private TextView text_a;
        private TextView text_b;
        private ImageView img_a;
    }
    class ViewHandler2{
        private TextView text_c;
        private TextView text_d;
        private ImageView img_b;
    }
}
