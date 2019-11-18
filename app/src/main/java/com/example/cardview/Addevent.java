package com.example.cardview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Addevent extends AppCompatActivity implements View.OnClickListener {

    private Calendar cal;
    private int year,month,day;
    private TextView tvShowDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);//添加打卡事件
        //上面条条隐藏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //获取当前日期
        getDate();
        tvShowDialog=(TextView) findViewById(R.id.tvShowDialog);
        tvShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tvShowDialog:
                        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker arg0, int year, int month, int day) {
                                tvShowDialog.setText(year+"-"+(++month)+"-"+day);      //将选择的日期显示到TextView中,因为之前获取month直接使用，所以不需要+1，这个地方需要显示，所以+1
                            }
                        };
                        DatePickerDialog dialog=new DatePickerDialog(Addevent.this, DatePickerDialog.THEME_HOLO_LIGHT,listener,year,month,day);//主题在这里！后边三个参数为显示dialog时默认的日期，月份从0开始，0-11对应1-12个月
                        dialog.show();
                        break;

                    default:
                        break;
                }
            }
        });
    }
    //获取当前日期
    private void getDate() {
        cal=Calendar.getInstance();
        year=cal.get(Calendar.YEAR);       //获取年月日时分秒
        Log.i("wxy","year"+year);
        month=cal.get(Calendar.MONTH);   //获取到的月份是从0开始计数
        day=cal.get(Calendar.DAY_OF_MONTH);
    }

}
