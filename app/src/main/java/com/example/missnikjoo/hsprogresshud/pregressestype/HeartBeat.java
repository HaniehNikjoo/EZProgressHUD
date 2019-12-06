package com.example.missnikjoo.hsprogresshud.pregressestype;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.missnikjoo.hsprogresshud.HSProgressModel;
import com.example.missnikjoo.hsprogresshud.hsbaseview.HSBaseView;
import com.example.missnikjoo.hsprogresshud.interfaces.HSProgress;
import com.example.missnikjoo.hsprogresshud.interfaces.HSProgressAnimation;

public class HeartBeat extends HSBaseView implements HSProgress, HSProgressAnimation {
    ShapeDrawable circle1= new ShapeDrawable();
    ShapeDrawable circle2= new ShapeDrawable();
    ShapeDrawable circle3= new ShapeDrawable();

    public HeartBeat(Context context, HSProgressModel progress) {
        super(context, progress);
        show();
    }

    public HeartBeat(@NonNull Context context) {
        super(context);
        show();
    }

    public HeartBeat(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        show();
    }

    public HeartBeat(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        show();
    }


    @Override
    public void setAnimation() {
//        if (circle1.getAlpha() == 0) {
//            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(circle1, PropertyValuesHolder.ofInt("alpha", 255));
//            animator.setTarget(circle1);
//            animator.setDuration(2000);
//            animator.start();
//        } else {
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(circle1, PropertyValuesHolder.ofInt("alpha", 0));
        animator.setTarget(circle1);
        animator.setDuration(4000);
        animator.start();
//        }
    }

    @Override
    public void setLayers() {

        set(layerGenerator(circle1,ShapeLayerType.TRACK));
        set(layerGenerator(circle2,ShapeLayerType.INNER_PILSATE));
        set(layerGenerator(circle3,ShapeLayerType.PULSATE));

        setAnimation();
    }

    @Override
    public void show() {
        setLayers();
    }

    @Override
    public void dismiss() {

    }

    private void set(Drawable oval) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(oval);
        } else {
            setBackgroundDrawable(oval);
        }
    }
}
