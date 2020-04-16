package com.example.missnikjoo.hsprogresshud.pregressestype;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import com.example.missnikjoo.hsprogresshud.HSProgressModel;
import com.example.missnikjoo.hsprogresshud.hsbaseview.HSBaseView;
import com.example.missnikjoo.hsprogresshud.interfaces.HSProgress;
import com.example.missnikjoo.hsprogresshud.interfaces.HSProgressAnimation;

public class HeartBeat extends HSBaseView implements HSProgress, HSProgressAnimation {

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
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);
        fadeOut.setRepeatCount(100);
        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        this.startAnimation(animation);
    }

    @Override
    public void setLayers() {

        layerGenerator(new ShapeDrawable(),ShapeLayerType.PULSATE);
        layerGenerator(new ShapeDrawable(),ShapeLayerType.INNER_PILSATE);
        layerGenerator(new ShapeDrawable(),ShapeLayerType.TRACK);

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
