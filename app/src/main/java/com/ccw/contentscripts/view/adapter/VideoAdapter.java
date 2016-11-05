package com.ccw.contentscripts.view.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.bean.VideoBean;
import com.squareup.picasso.Picasso;

import org.lenve.customshapeimageview.CustomShapeImageView;

import java.io.IOException;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/11/5 0005.
 */

public class VideoAdapter extends BaseAdapter {
    private List<VideoBean> list;
    private Context context;
    private LayoutInflater inflater;
    private MediaPlayer player;
    //记录当前正在播放的item的position
    private int currentPosition = -1;

    public VideoAdapter(List<VideoBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        player = new MediaPlayer();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
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
            convertView = inflater.inflate(R.layout.video_item, parent, false);
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
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.surfaceView = (SurfaceView) convertView.findViewById(R.id.surface_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        VideoBean bean = list.get(position);

        //重新绘画iv，surfaceView的高度
        int height = bean.getHeight();
        ViewGroup.LayoutParams lp = holder.iv.getLayoutParams();
        lp.height = height+150;
        holder.iv.requestLayout();
        holder.surfaceView.setLayoutParams(lp);

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
            holder.username.setText(bean.getName());
        }
        holder.content.setText(bean.getContent());
        holder.btn.setText(bean.getCategory_name());
        holder.digg_count.setText(bean.getDigg_count()+"");
        holder.bury_count.setText(bean.getBury_count()+"");
        holder.hot_count.setText(bean.getComment_count()+"");
        holder.share_count.setText(bean.getShare_count()+"");

        Picasso.with(context).load(bean.getImageUrl()).into(holder.iv);

        Object tag = holder.iv.getTag();
        if (tag != null) {
            Integer tag1 = (Integer) tag;
            if (tag1 == currentPosition && tag1 != position) {
                player.stop();
                currentPosition = -1;
            }
        }


        holder.iv.setTag(position);
        if (currentPosition == position) {
            holder.iv.setVisibility(View.INVISIBLE);
            holder.surfaceView.setVisibility(View.VISIBLE);
            player.reset();
            player.setDisplay(holder.surfaceView.getHolder());
            try {
                player.setDataSource(bean.getVideoUrl());
                player.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            holder.iv.setVisibility(View.VISIBLE);
            holder.surfaceView.setVisibility(View.INVISIBLE);
        }

        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()) {
                    player.stop();
                }
                Integer tag = (Integer) v.getTag();
                currentPosition = tag;
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    class ViewHolder{
        ImageView label,iv;
        CustomShapeImageView userFace;
        TextView username, content, digg_count, bury_count, hot_count, share_count;
        Button btn;
        SurfaceView surfaceView;
    }
}
