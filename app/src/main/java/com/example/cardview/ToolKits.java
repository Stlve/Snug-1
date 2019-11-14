package com.example.cardview;

import android.content.Context;
import android.content.SharedPreferences;

public class ToolKits {
    public static SharedPreferences getSharedPerferences(Context context){

        return context.getSharedPreferences("包名",Context.MODE_PRIVATE);//设计为私有模式
}
//设置共享参数
        public static void putBoolean(Context context,String key,boolean value){
        SharedPreferences sharedPerferences=getSharedPerferences(context);
        //获取共享参数的编辑器
            SharedPreferences.Editor editor=sharedPerferences.edit();
//通过编辑器提交一个boolean类型的参数
        editor.putBoolean(key,value);
        editor.commit();
}
    //获取共享参数
    public static boolean GetBoolean(Context context, String key, boolean defaultValue){
        return  getSharedPerferences(context).getBoolean(key,defaultValue);
    }
}
