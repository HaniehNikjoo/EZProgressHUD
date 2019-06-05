package com.example.missnikjoo.hsprogresshud.pregressestype;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.TextView;

import com.example.missnikjoo.hsprogresshud.HSProgressModel;
import com.example.missnikjoo.hsprogresshud.Interfaces;
import com.example.missnikjoo.hsprogresshud.hsbaseview.HSBaseView;

public class HeartBeat extends HSBaseView implements Interfaces.HSProgress, Interfaces.HSProgressAnimation {
    TextView textView;

    public HeartBeat(Context context, HSProgressModel progress) {
        super(context, progress);
        textView=new TextView(context);
        show();

    }

    @Override
    public void setAnimation() {
    }

    @Override
    public void setLayers() {
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(14);
        GradientDrawable shapeLayer = new GradientDrawable();

        layerGenerator(shapeLayer,ShapeLayerType.TRACK);
        layerGenerator(shapeLayer,ShapeLayerType.INNER_PILSATE);
        layerGenerator(shapeLayer,ShapeLayerType.PULSATE);

        setAnimation();
    }

    @Override
    public void show() {
        setLayers();
    }

    @Override
    public void dismiss() {

    }
}
