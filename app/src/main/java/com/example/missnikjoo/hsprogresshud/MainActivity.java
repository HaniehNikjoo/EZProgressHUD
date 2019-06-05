package com.example.missnikjoo.hsprogresshud;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.missnikjoo.hsprogresshud.factory.HSFactory;
import com.example.missnikjoo.hsprogresshud.hsbaseview.HSBaseView;
import com.example.missnikjoo.hsprogresshud.pregressestype.HeartBeat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getMeasure(this);
        HSProgressModel options=new HSProgressModel.HSProgressOptions()
                .animationOption(HSProgressModel.HSAnimationOptions.HEAR_BEAT)
                .radius(100)
                .firstLayerStrokeColor(App.mContext.getResources().getColor(R.color.colorPrimaryDark))
                .secondLayerStrokeColor(App.mContext.getResources().getColor(R.color.colorPrimaryDark))
                .thirdLayerStrokeColor(App.mContext.getResources().getColor(R.color.colorPrimaryDark))
                .init();

        HSBaseView hud = HSFactory.set(this,options);
        hud.show();

//        GradientDrawable shapeLayer = new GradientDrawable();
//        shapeLayer.setStroke(10,App.mContext.getResources().getColor(R.color.colorPrimaryDark));
//        shapeLayer.setSize(100,100);
//        shapeLayer.setCornerRadius(17);
//        shapeLayer.setShape(GradientDrawable.OVAL);
//        shapeLayer.setGradientCenter(App.height/2,App.width/2);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            findViewById(R.id.img).setBackground(shapeLayer);
//        } else {
//            //noinspection deprecation
//            findViewById(R.id.img).setBackgroundDrawable(shapeLayer);
//        }

    }


}
