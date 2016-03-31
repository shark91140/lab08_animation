package com.example.studente3.lab08_animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView m_img_duke;
    private AnimationDrawable m_Frame_Animation;
    private TextView m_tv_time;
    private Button m_btn_start_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFrameAnimation();
    }

    private void initFrameAnimation() {
        m_img_duke.setBackgroundResource(R.drawable.frame_ainmation);
        m_Frame_Animation = (AnimationDrawable)m_img_duke.getBackground();
    }

    private void initView() {
        m_img_duke = (ImageView)findViewById(R.id.img_duke);
        m_tv_time = (TextView)findViewById(R.id.tv_time);
    }


    public void click(View view) {
        switch (view.getId()){
            case R.id.btn_start :
                m_Frame_Animation.start();
                break;
            case R.id.btn_stop:
                m_Frame_Animation.stop();
                break;
            case R.id.btn_5sec:
                animation5secs();
                break;
        }
    }
    private Handler m_Handler = new Handler();

    private void animation5secs() {
        int delayMillis = 5 * 1000;
        Runnable task = new Task();
        boolean result = m_Handler.postDelayed(task, delayMillis);
        m_tv_time.setText(result ? "交付成功" : "交付失敗");
        m_Frame_Animation.start();
    }

    private class Task implements Runnable {
        @Override
        public void run() {

            m_Frame_Animation.stop();
            m_tv_time.setText("時間到");

        }
    }



}
