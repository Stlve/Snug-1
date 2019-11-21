package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;



public class SplashActivity extends AppCompatActivity {

    // private final int SPLASH_DISPLAY_LENGHT = 2000; // 两秒后进入系统
    public static final String IS_FIRST="is_first";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_splash);
        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if(ToolKits.GetBoolean(SplashActivity.this,IS_FIRST,false))
                {
                    //如果默认值为false，则没有登陆过，跳转到引导页
                    startActivity(new Intent(SplashActivity.this,Guide.class));
                    //将boolean值设置为true
                    ToolKits.putBoolean(SplashActivity.this,IS_FIRST,true);
                }else{
                    //否则跳转为主页
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
                ToolKits.putBoolean(SplashActivity.this,IS_FIRST,true);
                return true;
            }
        }).sendEmptyMessageDelayed(0,2000);/*延迟1s*/
        Thread myThread=new Thread(){//创建子线程
            @Override
            public void run() {
                try{
                    sleep(2000);//使程序休眠五秒
                    Intent it=new Intent(getApplicationContext(),SplashActivity.class);//启动MainActivity
                    startActivity(it);
                    finish();//关闭当前活动
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程
    }
}
