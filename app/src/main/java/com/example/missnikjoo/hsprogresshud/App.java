package com.example.missnikjoo.hsprogresshud;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

public class App extends Application {
    public static Context mContext;
    public static int height;
    public static int width;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static void getMeasure(Activity activity){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
    }
}
