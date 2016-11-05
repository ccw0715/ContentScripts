package com.ccw.contentscripts.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ccw.contentscripts.BaseActivity;
import com.ccw.contentscripts.R;
import com.ccw.contentscripts.model.bean.CommentBean;
import com.ccw.contentscripts.model.bean.ScriptsBean;
import com.ccw.contentscripts.presenter.CommentPresenter;
import com.ccw.contentscripts.view.adapter.CommentAdapter;
import com.squareup.picasso.Picasso;

import org.lenve.customshapeimageview.CustomShapeImageView;

import java.util.List;

public class DetailsActivity extends BaseActivity implements IShowComment{

    private ImageView label;
    private CustomShapeImageView userFace;
    private TextView username;
    private TextView content;
    private Button btn;
    private TextView digg_count;
    private TextView bury_count;
    private TextView hot_count;
    private TextView share_count;
    private TextView hot_comment;
    private ListView lv;
    public static long id;

    private CommentPresenter presenter = new CommentPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        initData();
        presenter.start();
    }

    private void initView() {
        label = ((ImageView) findViewById(R.id.label));
        userFace = ((CustomShapeImageView) findViewById(R.id.userFace));
        username = ((TextView) findViewById(R.id.username));
        content = ((TextView) findViewById(R.id.content));
        btn = ((Button) findViewById(R.id.btn));
        digg_count = ((TextView) findViewById(R.id.digg_count));
        bury_count = ((TextView) findViewById(R.id.bury_count));
        hot_count = ((TextView) findViewById(R.id.hot_count));
        share_count = ((TextView) findViewById(R.id.share_count));
        hot_comment = ((TextView) findViewById(R.id.hot_comment));
        lv = ((ListView) findViewById(R.id.lv));
    }

    private void initData() {
        Intent intent = getIntent();
        String flag = intent.getStringExtra("flag");
        if (flag.equals("bean")) {
            ScriptsBean bean = (ScriptsBean) intent.getSerializableExtra("bean");
            id = bean.getId();
            String s = bean.getLabel();
            if (s.equals("热门投稿")) {
                label.setImageResource(R.drawable.ic_label_hot);
            } else {
                label.setImageResource(R.drawable.ic_label_same_city);
            }
            if (bean.getName().equals("匿名用户")) {
                username.setText("匿名用户");
                userFace.setImageResource(R.mipmap.ic_launcher);
            } else {
                Picasso.with(this).load(bean.getAvatar_url()).into(userFace);
                username.setText(bean.getName());
            }
            content.setText(bean.getContent());
            btn.setText(bean.getCategory_name());
            digg_count.setText(bean.getDigg_count() + "");
            bury_count.setText(bean.getBury_count() + "");
            hot_count.setText(bean.getComment_count() + "");
            share_count.setText(bean.getShare_count() + "");
            hot_comment.setText("新鲜评论(" + bean.getComment_count() + ")");
        }

    }
    //返回按钮点击事件
    public void back(View view) {
        this.finish();
    }

    @Override
    public void setList(List<CommentBean> list) {
        CommentAdapter adapter = new CommentAdapter(list,DetailsActivity.this);
        lv.setAdapter(adapter);
    }
}