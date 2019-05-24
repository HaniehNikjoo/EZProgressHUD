package com.example.missnikjoo.hsprogresshud;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    BounceHSProgressHUD hsProgressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHSProgress();
    }

    private void initHSProgress(){
        hsProgressHUD=findViewById(R.id.hspProgress);
        hsProgressHUD.setTextWaiting("Pleas Wait...");
        hsProgressHUD.setColorStaticCircle(Color.BLUE);
        hsProgressHUD.setColorDynamicCircle(Color.BLUE);
    }
}
