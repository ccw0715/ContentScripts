package com.ccw.contentscripts.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.bean.ScriptsBean;
import com.squareup.picasso.Picasso;

import org.lenve.customshapeimageview.CustomShapeImageView;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class MyAdapter extends BaseAdapter {
    private List<ScriptsBean> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<ScriptsBean> list, Context context) {
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.scripts_normal_item, parent, false);
            holder = new ViewHolder();
            holder.label = (ImageView) convertView.findViewById(R.id.label);
            holder.userFace = (CustomShapeImageView) convertView.findViewById(R.id.userFace);
            holder.username = (TextView) convertView.findViewById(R.id.username);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.digg_count = (TextView) convertView.findViewById(R.id.digg_count);
            holder.bury_count = (TextView) convertView.findViewById(R.id.bury_count);
            holder.hot_count = (TextView) convertView.findViewById(R.id.hot_count);
            holder.share_count = (TextView) convertView.findViewById(R.id.share_count);
            holder.btn = (Button) convertView.findViewById(R.id.btn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ScriptsBean bean = list.get(position);
        String label = bean.getLabel();
        if (label.equals("热门投稿")) {
            holder.label.setImageResource(R.drawable.ic_label_hot);
        }else {
            holder.label.setImageResource(R.drawable.ic_label_same_city);
        }
        if(bean.getName().equals("匿名用户")){
            holder.username.setText("匿名用户");
            holder.userFace.setImageResource(R.mipmap.ic_launcher);
        }else {
            Picasso.with(context).load(bean.getAvatar_url()).into(holder.userFace);
//            holder.userFace.setImageURI(Uri.parse(bean.getAvatar_url()));
            holder.username.setText(bean.getName());
        }
        holder.content.setText(bean.getContent());
        holder.btn.setText(bean.getCategory_name());
        holder.digg_count.setText(bean.getDigg_count()+"");
        holder.bury_count.setText(bean.getBury_count()+"");
        holder.hot_count.setText(bean.getComment_count()+"");
        holder.share_count.setText(bean.getShare_count()+"");
        return convertView;
    }

    class ViewHolder {
        ImageView label;
        CustomShapeImageView userFace;
        TextView username, content, digg_count, bury_count, hot_count, share_count;
        Button btn;
    }
}
