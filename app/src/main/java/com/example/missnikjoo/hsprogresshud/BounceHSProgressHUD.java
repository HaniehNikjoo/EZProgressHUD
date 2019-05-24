package com.example.missnikjoo.hsprogresshud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class BounceHSProgressHUD extends BaseHSProgressHUD{

    public BounceHSProgressHUD(@NonNull Context context) {
        super(context);
        initAnimation();
    }

    public BounceHSProgressHUD(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAnimation();
    }

    public BounceHSProgressHUD(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAnimation();
    }

    @SuppressLint("NewApi")
    public BounceHSProgressHUD(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAnimation();
    }

    private void initAnimation(){
        Animation logoMoveAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_animation);
        dynamicImageview.startAnimation(logoMoveAnimation);
    }


}
