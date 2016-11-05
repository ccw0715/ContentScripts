package com.ccw.contentscripts.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.bean.EssenceBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public class EssenceAdapter extends BaseAdapter {
    private List<EssenceBean> list;
    private Context context;
    private LayoutInflater inflater;

    public EssenceAdapter(List<EssenceBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
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
        ViewHolder holder;
        EssenceBean bean = list.get(position);
        switch (bean.getKeywords()){
            case "":
                if(convertView == null){
                    convertView = inflater.inflate(R.layout.esscence_iv_item,parent,false);
                    holder= new ViewHolder();
                    holder.iv = (ImageView) convertView.findViewById(R.id.pic);
                    holder.tv = (TextView) convertView.findViewById(R.id.title);
                    convertView.setTag(holder);
                }else {
                    holder = (ViewHolder) convertView.getTag();
                }
                Picasso.with(context).load(bean.getImage_url()).into(holder.iv);
                holder.tv.setText(bean.getTitle());
                break;
            case "网络聊天,今日精选段子":
                if(convertView == null){
                    convertView = inflater.inflate(R.layout.essence_lv_item,parent,false);
                    holder= new ViewHolder();
                    holder.iv = (ImageView) convertView.findViewById(R.id.img);
                    holder.tv = (TextView) convertView.findViewById(R.id.title);
                    convertView.setTag(holder);
                }else {
                    holder = (ViewHolder) convertView.getTag();
                }
                break;
        }
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
