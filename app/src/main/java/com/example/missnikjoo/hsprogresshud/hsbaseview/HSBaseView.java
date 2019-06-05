package com.example.missnikjoo.hsprogresshud.hsbaseview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import com.example.missnikjoo.hsprogresshud.App;
import com.example.missnikjoo.hsprogresshud.HSProgressModel;
import com.example.missnikjoo.hsprogresshud.Interfaces;

public class HSBaseView extends android.support.v7.widget.AppCompatImageView implements Interfaces.HSProgress{

    @Override
    public void show() {

    }

    @Override
    public void dismiss() {

    }

    public enum ShapeLayerType {
        TRACK, PULSATE, INNER_PILSATE
    }

    protected HSProgressModel progress;

    public HSBaseView(Context context,HSProgressModel progress){
        super(context);
        this.progress=progress;
    }

    /// this method set the circles position, path, fillColor and.........
    public void layerGenerator(GradientDrawable shapeLayer, ShapeLayerType type) {

        switch (type) {
            case TRACK:
                shapeLayer.setStroke(progress.strokeWidth,progress.firstLayerStrokeColor);
            case PULSATE:
                shapeLayer.setStroke(progress.strokeWidth,progress.secondLayerStrokeColor);
                shapeLayer.setAlpha(5);
            case INNER_PILSATE:
                shapeLayer.setStroke(progress.strokeWidth,progress.thirdLayerStrokeColor);
        }
        shapeLayer.setSize(progress.radius,progress.radius);
        shapeLayer.setCornerRadius(progress.radius);
        shapeLayer.setShape(GradientDrawable.OVAL);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(shapeLayer);
        } else {
            //noinspection deprecation
            setBackgroundDrawable(shapeLayer);
        }
    }


}
