package com.example.missnikjoo.hsprogresshud.hsbaseview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.missnikjoo.hsprogresshud.App;
import com.example.missnikjoo.hsprogresshud.HSProgressModel;
import com.example.missnikjoo.hsprogresshud.R;

public class  HSBaseView extends View {
    protected Paint circle1;
    protected Paint circle2;
    protected Paint circle3;
    private Paint drawPaint;
    private float size1;
    private float size2;
    private float size3;
    private int centerX,centerY;
    Canvas canvas;
    Rect rect;
    ShapeLayerType type;

    public enum ShapeLayerType {
        TRACK, PULSATE, INNER_PILSATE
    }

    protected HSProgressModel progress;

    public HSBaseView(Context context, HSProgressModel progress) {
        super(context);
        this.progress = progress;
        initView();
    }

    public HSBaseView(@NonNull Context context) {
        super(context);
        initView();
    }

    public HSBaseView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public HSBaseView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /// this method set the circles position, path, fillColor and.........
    public Drawable layerGenerator(ShapeDrawable mShape, ShapeLayerType type) {
        this. type = type;
        setOnMeasureCallback();
        drawPaint = new Paint();
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        switch (type) {
            case TRACK:
//                drawPaint.setColor(progress.firstLayerStrokeColor);
                drawPaint.setColor(App.mContext.getResources().getColor(R.color.light_sky_blue));
                drawPaint.setStrokeWidth(15);
//                size = size / 3;
                circle1 = drawPaint;
                break;
            case PULSATE:
//                drawPaint.setColor(progress.secondLayerStrokeColor);
                drawPaint.setColor(App.mContext.getResources().getColor(R.color.colorPrimaryDark));
                drawPaint.setStrokeWidth(15);
                circle2 = drawPaint;
                break;
            case INNER_PILSATE:
//                drawPaint.setColor(progress.thirdLayerStrokeColor);
                drawPaint.setColor(App.mContext.getResources().getColor(R.color.navy));
                drawPaint.setStrokeWidth(15);
//                size = size / 2;
                circle3 = drawPaint;
                break;
        }

        mShape = new ShapeDrawable(new Shape() {
            @Override
            public void draw(Canvas c, Paint paint) {
                forceLayout();
            }
        });
        return mShape;
    }

    private void setOnMeasureCallback() {
        ViewTreeObserver vto = getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                removeOnGlobalLayoutListener(this);
                size1 = (float) (getMeasuredWidth() / (3.05));
                size2 = (float) (getMeasuredWidth() / (3.15));
                size3 = (float) (getMeasuredWidth() / (3.30));

                centerX = getMeasuredWidth();
                centerY = getMeasuredHeight();

            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void removeOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener listener) {
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(listener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(listener);
        }
    }

    private void initView() {
        canvas=new Canvas();
        setOnMeasureCallback();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect = new Rect();
        rect.left=0;
        rect.top=0;
        rect.right=50;
        rect.bottom=50;

        this.canvas = canvas;

        Paint newPaint = new Paint();
        newPaint.setColor(App.mContext.getResources().getColor(R.color.white));
        newPaint.setTextSize(60);
        canvas.drawText("Please wait...", (float) (centerX/2.9), centerY/2, newPaint);


        Paint paint=new Paint();
        paint.setColor(Color.argb(12,0,0,0));
        canvas.drawCircle(centerX/2, centerY/2, size1, circle1);
        canvas.drawCircle(centerX/2, centerY/2, size2, circle2);
        canvas.drawCircle(centerX/2, centerY/2, size3, circle3);

    }

}
