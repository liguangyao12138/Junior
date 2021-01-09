package com.example.junior;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junior.util.DateUtil;

public class SimpleWidget extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private TextView tv_marquee;
    private Boolean isPaused = false;// 跑马灯文字是否暂停滚动

    private TextView tv_control;
    private TextView tv_bbs;

    private String[] mChatStr = {"你吃饭了吗？", "今天天气真好呀。",
            "我中奖啦！", "我们去看电影吧", "晚上干什么好呢？",};

    private Button btn_click;

    private ImageView iv_scale;

    private Button btn_chat;
    private Button btn_capture;
    private TextView tv_capture;
    private ImageView iv_capture;

    private Button btn_icon;
    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_widget);

        tv_marquee = findViewById(R.id.tv_marquee);
        tv_marquee.setOnClickListener(this);

        tv_control = findViewById(R.id.tv_control);
        tv_control.setOnClickListener(this);
        tv_control.setOnLongClickListener(this);

        tv_bbs = findViewById(R.id.tv_bbs);
        tv_bbs.setOnClickListener(this);
        tv_bbs.setOnLongClickListener(this);

        btn_click = findViewById(R.id.btn_click);
        btn_click.setOnClickListener(this);
        btn_click.setOnLongClickListener(this);

        iv_scale = findViewById(R.id.iv_scale);
        findViewById(R.id.btn_center).setOnClickListener(this);
        findViewById(R.id.btn_fitCenter).setOnClickListener(this);
        findViewById(R.id.btn_centerCrop).setOnClickListener(this);
        findViewById(R.id.btn_centerInside).setOnClickListener(this);
        findViewById(R.id.btn_fitXY).setOnClickListener(this);
        findViewById(R.id.btn_fitStart).setOnClickListener(this);
        findViewById(R.id.btn_fitEnd).setOnClickListener(this);

        btn_chat = findViewById(R.id.btn_chat);
        btn_chat.setOnClickListener(this);
        btn_capture = findViewById(R.id.btn_capture);
        btn_capture.setOnClickListener(this);

        tv_capture = findViewById(R.id.tv_capture);
        iv_capture = findViewById(R.id.iv_capture);
        tv_capture.setDrawingCacheEnabled(true);

        btn_icon = findViewById(R.id.btn_icon);
        drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_top).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
        findViewById(R.id.btn_bottom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tv_marquee){

            isPaused = !isPaused;
            if(isPaused){
                tv_marquee.setFocusable(false);// 不允许获得焦点
                tv_marquee.setFocusableInTouchMode(false);// 允许在触摸时获得焦点
            }else {
                tv_marquee.setFocusable(true);
                tv_marquee.setFocusableInTouchMode(true);
                tv_marquee.requestFocus();// 强制获得焦点，让跑马灯滚起来
            }

        }else if(v.getId() == R.id.tv_control || v.getId() == R.id.tv_bbs){
            // 生成一个0到4之间的随机数
            int random  = (int) (Math.random() * 10) % 5;
            // 拼接聊天的文本内容
            String newStr = String.format("%s\n%s %s",
                    tv_bbs.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
            // 设置文本视图tv_bbs的文本内容
            tv_bbs.setText(newStr);

        }else if(v.getId()==R.id.btn_click){
            Toast.makeText(this, "你点击了控件", Toast.LENGTH_SHORT).show();

        }else if (v.getId()==R.id.btn_center){
            iv_scale.setScaleType(ImageView.ScaleType.CENTER);
        }else if(v.getId()==R.id.btn_fitCenter){
            iv_scale.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }else if(v.getId()==R.id.btn_centerCrop){
            iv_scale.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else if(v.getId()==R.id.btn_centerInside){
            iv_scale.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }else if(v.getId()==R.id.btn_fitXY){
            iv_scale.setScaleType(ImageView.ScaleType.FIT_XY);
        }else if(v.getId()==R.id.btn_fitStart){
            iv_scale.setScaleType(ImageView.ScaleType.FIT_START);
        }else if(v.getId()==R.id.btn_fitEnd){
            iv_scale.setScaleType(ImageView.ScaleType.FIT_END);

        }else if(v.getId()==R.id.btn_chat){
            int random = (int)(Math.random()*10)%5;
            //String newStr = String.format("%s\n%s %s" , tv_capture.getText().toString(),DateUtil.getNowTime(),mChatStr[random]);
            String newStr = String.format("%s\n%s %s",
                    tv_capture.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
            tv_capture.setText(newStr);
        }else if(v.getId()==R.id.btn_capture){
            Bitmap bitmap = tv_capture.getDrawingCache();
            iv_capture.setImageBitmap(bitmap);
            mHandler.postDelayed(mResetCache,200);

        }else if(v.getId()==R.id.btn_left){
            btn_icon.setCompoundDrawables(drawable,null,null,null);
        }else if(v.getId()==R.id.btn_top){
            btn_icon.setCompoundDrawables(null,drawable,null,null);
        }else if(v.getId()==R.id.btn_right){
            btn_icon.setCompoundDrawables(null,null,drawable,null);
        }else if(v.getId()==R.id.btn_bottom){
            btn_icon.setCompoundDrawables(null,null,null,drawable);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        //长按删除聊天记录
        if (v.getId() == R.id.tv_control || v.getId() == R.id.tv_bbs) {
            tv_bbs.setText("");

        }else if(v.getId() == R.id.btn_click){
            Toast.makeText(this, "你长按了按钮", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private Handler mHandler = new Handler();
    private Runnable mResetCache = new Runnable() {
        @Override
        public void run() {
            tv_capture.setDrawingCacheEnabled(false);
            tv_capture.setDrawingCacheEnabled(true);
        }
    };
}