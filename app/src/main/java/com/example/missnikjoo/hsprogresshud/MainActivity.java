package com.example.missnikjoo.hsprogresshud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.missnikjoo.hsprogresshud.factory.HSFactory;
import com.example.missnikjoo.hsprogresshud.interfaces.HSProgress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HSProgressModel options = new HSProgressModel.HSProgressOptions()
                .animationOption(HSProgressModel.HSAnimationOptions.HEAR_BEAT)
                .radius(100)
                .firstLayerStrokeColor(App.mContext.getResources().getColor(R.color.colorPrimaryDark))
                .secondLayerStrokeColor(App.mContext.getResources().getColor(R.color.aqua))
                .thirdLayerStrokeColor(App.mContext.getResources().getColor(R.color.light_sky_blue))
                .init();

        HSProgress hud = HSFactory.set(this, options);
        hud.show();

    }

}
