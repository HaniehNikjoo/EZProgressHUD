package com.example.missnikjoo.hsprogresshud.factory;

import android.content.Context;

import com.example.missnikjoo.hsprogresshud.HSProgressModel;
import com.example.missnikjoo.hsprogresshud.hsbaseview.HSBaseView;
import com.example.missnikjoo.hsprogresshud.pregressestype.HeartBeat;
import com.example.missnikjoo.hsprogresshud.pregressestype.LineLayer;
import com.example.missnikjoo.hsprogresshud.pregressestype.LordOfTheRings;
import com.example.missnikjoo.hsprogresshud.pregressestype.XRotation;
import com.example.missnikjoo.hsprogresshud.pregressestype.XYRotation;
import com.example.missnikjoo.hsprogresshud.pregressestype.YRotation;

public class HSFactory {

//    private HSFactory(){}

    public static HSBaseView set(Context context,HSProgressModel progress){

        switch (progress.animationOption) {

            case HEAR_BEAT:

                return new HeartBeat(context,progress);

            case X_ROTATION:

                return new XRotation(context,progress);

            case LINE_LAYER:

                return new LineLayer(context,progress);

            case LORD_OF_THE_RINGS:

                return new LordOfTheRings(context,progress);

            case XY_ROTATION:

                return new XYRotation(context,progress);

            case Y_ROTAION:

                return new YRotation(context,progress);
        }

        return null;
    }
}