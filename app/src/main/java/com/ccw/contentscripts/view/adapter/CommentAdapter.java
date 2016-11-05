package com.ccw.contentscripts.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.bean.CommentBean;
import com.squareup.picasso.Picasso;

import org.lenve.customshapeimageview.CustomShapeImageView;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public class CommentAdapter extends BaseAdapter {
    private List<CommentBean> list;
    private Context context;
    private LayoutInflater inflater;

    public CommentAdapter(List<CommentBean> list, Context context) {
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
            convertView = inflater.inflate(R.layout.comment_item, parent, false);
            holder = new ViewHolder();
            holder.userFace = ((CustomShapeImageView) convertView.findViewById(R.id.userFace));
            holder.username = (TextView) convertView.findViewById(R.id.username);
            holder.digg_count = (TextView) convertView.findViewById(R.id.digg_count);
            holder.comment = (TextView) convertView.findViewById(R.id.comment);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CommentBean bean = list.get(position);
        if (bean.getUserFace() != null && !bean.getUserFace().equals("")) {
            Picasso.with(context).load(bean.getUserFace()).into(holder.userFace);
        } else {
            holder.userFace.setImageResource(R.mipmap.ic_launcher);
        }
        holder.username.setText(bean.getUsername() + "");
        holder.digg_count.setText(bean.getDigg_count() + "");
        holder.comment.setText(bean.getContent() + "");
        return convertView;
    }

    class ViewHolder {
        CustomShapeImageView userFace;
        TextView username, digg_count, comment;
    }
}
