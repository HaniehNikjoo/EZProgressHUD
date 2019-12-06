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

import com.example.missnikjoo.hsprogresshud.HSProgressModel;

public class HSBaseView extends View {
    private Paint drawPaint;
    private float size;
    private int centerX,centerY;
    Canvas canvas;
    Rect rect;
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
        setOnMeasureCallback();
        drawPaint = new Paint();
        drawPaint.setStyle(Paint.Style.STROKE);
//        drawPaint.setColor(Color.RED);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
//        drawPaint.setAntiAlias(true);
        switch (type) {
            case TRACK:
//                drawPaint.setColor(progress.firstLayerStrokeColor);
                drawPaint.setColor(Color.RED);
                drawPaint.setStrokeWidth(10);
                size = size / 3;

//                canvas.drawRect(30, 30, 200, 200, drawPaint);

//                forceLayout();

//                draw(canvas);
//                postInvalidate();
//                oval.getPaint().setColor(progress.firstLayerStrokeColor);

                break;
            case PULSATE:
//                drawPaint.setColor(progress.secondLayerStrokeColor);
                drawPaint.setColor(Color.YELLOW);
                drawPaint.setStrokeWidth(20);
                size = size;

//                canvas.drawRect(30, 30, 200, 200, drawPaint);


//                forceLayout();

//                draw(canvas);
//                postInvalidate();

//                oval.getPaint().setColor(progress.secondLayerStrokeColor);

                break;
            case INNER_PILSATE:
//                drawPaint.setColor(progress.thirdLayerStrokeColor);
                drawPaint.setColor(Color.GREEN);
                drawPaint.setStrokeWidth(30);

                size = size / 2;

//                canvas.drawRect(30, 30, 200, 200, drawPaint);


//                draw(canvas);
//                postInvalidate();

//                oval.getPaint().setColor(progress.thirdLayerStrokeColor);

                break;
        }

        mShape = new ShapeDrawable(new Shape() {
            @Override
            public void draw(Canvas c, Paint paint) {

//                canvas.translate(App.pxToDp(centerX),App.pxToDp(centerY));
                canvas.drawCircle(centerX/2, centerY/2, size, drawPaint);
                forceLayout();
//                invalidate();
//                postInvalidate();
            }
        });

        // redraw
//        invalidate();
//        requestLayout();

        return mShape;
    }

    private void setOnMeasureCallback() {
        ViewTreeObserver vto = getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                removeOnGlobalLayoutListener(this);
                size = getMeasuredWidth() / 3;
//                centerX = getMeasuredWidth() / 2;
//                centerY = getMeasuredHeight() / 2;
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
//        setWillNotDraw(true);
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
        Paint paint=new Paint();
        paint.setColor(Color.argb(12,0,0,0));
        canvas.drawRect(rect,paint);
//        canvas.drawCircle(centerX, centerY, size, drawPaint);
    }
}
