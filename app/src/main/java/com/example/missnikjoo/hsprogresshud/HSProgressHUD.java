package com.example.missnikjoo.hsprogresshud;

import android.content.Context;

public class HSProgressHUD {

    private Context mContext;
    private int mAnimateDuration;
    private double mFromXScale;
    private double mFromYScale;
    private double mToXScale;
    private double mToYScale;
    private int mPivotX;
    private int mPivotY;

    public HSProgressHUD(Context context){
        mContext=context;
        mAnimateDuration=1000;
        mFromXScale=0.9;
        mFromYScale=0.9;
        mToXScale=1;
        mToYScale=1;

    }
}
