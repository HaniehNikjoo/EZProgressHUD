package com.example.missnikjoo.hsprogresshud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseHSProgressHUD extends FrameLayout{
    protected ImageView staticImageView,dynamicImageview;
    protected TextView txtWait;

    public BaseHSProgressHUD(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public BaseHSProgressHUD(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BaseHSProgressHUD(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @SuppressLint("NewApi")
    public BaseHSProgressHUD(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    protected void initView(Context context){
        View v = LayoutInflater.from(getContext()).inflate(R.layout.hsprogress_hud, this);
        staticImageView=v.findViewById(R.id.image1);
        dynamicImageview=v.findViewById(R.id.image2);
        txtWait=v.findViewById(R.id.txtWait);

    }

//    public BaseHSProgressHUD setColorStaticCircle(int color){
//        this.color = color;
////        staticImageView.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),getContext().getResources().getColor(this.color)));
////        staticImageView.setBackgroundColor(getContext().getResources().getColor(this.color));
//        return this;
//    }

//    public BaseHSProgressHUD setColorDynamicCircle(int color){
//        this.color = color;
////        dynamicImageview.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),color));
//        return this;
//    }

    protected void setTextWaiting(String str){
        txtWait.setText(str);
    }


    protected void setColorStaticCircle(int color){
        Drawable mDrawable = ContextCompat.getDrawable(getContext(), R.drawable.static_circle);
        mDrawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        staticImageView.setBackgroundDrawable(mDrawable);
    }

    protected void setColorDynamicCircle(int color){
        Drawable mDrawable = ContextCompat.getDrawable(getContext(), R.drawable.dynamic_circle);
        mDrawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        dynamicImageview.setBackgroundDrawable(mDrawable);
    }

}
