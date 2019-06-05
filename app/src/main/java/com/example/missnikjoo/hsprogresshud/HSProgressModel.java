package com.example.missnikjoo.hsprogresshud;

public class HSProgressModel {

    public enum HSAnimationOptions {
        /// diffrent types of animations
        HEAR_BEAT,LINE_LAYER,LORD_OF_THE_RINGS,X_ROTATION,Y_ROTAION,XY_ROTATION
    }

    /// the color of main circle (by default is UIColor(red: 220/255, green: 20/255, blue: 60/255, alpha: 1))
    public int firstLayerStrokeColor;

    /// the width of stroke (by default is 17.0)
    public int strokeWidth;

    /// the color of mian pulsate layer that is transparent all the time (by default is UIColor(red: 220/255, green: 20/255, blue: 60/255, alpha: 1))
    public int secondLayerStrokeColor;

    /// the color of inner pulsate layer (by default is .gray)
    public int thirdLayerStrokeColor;

    /// title text (by default is Please Wait...)
    public String title;

    /// font of title text (by default is Papyrus size 18) AKA Papyrus is not Lame ;-) :D
//    public var font: UIFont = UIFont(name: HSStrings.fontName.rawValue, size: 18)!

    /// color of title text (by default is white)
    public int titleTextColor;

    /// the background transparent view color (by default is black)
    public int transViewBackgroundColor;

    /// the radius of the circles (by default is 105.0)
    public int radius;

    public HSAnimationOptions animationOption;


    public HSProgressModel(HSProgressOptions options){
        this.firstLayerStrokeColor=options.firstLayerStrokeColor;
        this.strokeWidth=options.strokeWidth;
        this.secondLayerStrokeColor=options.secondLayerStrokeColor;
        this.thirdLayerStrokeColor=options.thirdLayerStrokeColor;
        this.transViewBackgroundColor=options.transViewBackgroundColor;
        this.radius=options.radius;
        this.animationOption=options.animationOption;
    }


    public static class HSProgressOptions {
        public int firstLayerStrokeColor= App.mContext.getResources().getColor(R.color.colorPrimaryDark);

        public int strokeWidth=17;

        public int secondLayerStrokeColor=App.mContext.getResources().getColor(R.color.colorAccent);

        public int thirdLayerStrokeColor=App.mContext.getResources().getColor(R.color.dark_sea_green);

        public String title=App.mContext.getResources().getString(R.string.waiting);

        public int titleTextColor=App.mContext.getResources().getColor(R.color.white);

        public int transViewBackgroundColor=App.mContext.getResources().getColor(R.color.black_transparent);

        public int radius=50;

        public HSAnimationOptions animationOption= HSAnimationOptions.HEAR_BEAT;


        public HSProgressOptions firstLayerStrokeColor(int firstLayerStrokeColor){
            this.firstLayerStrokeColor=firstLayerStrokeColor;
            return this;
        }

        public HSProgressOptions strokeWidth(int strokeWidth){
            this.strokeWidth=strokeWidth;
            return this;
        }

        public HSProgressOptions secondLayerStrokeColor(int secondLayerStrokeColor){
            this.secondLayerStrokeColor=secondLayerStrokeColor;
            return this;
        }

        public HSProgressOptions thirdLayerStrokeColor(int thirdLayerStrokeColor){
            this.thirdLayerStrokeColor=thirdLayerStrokeColor;
            return this;
        }

        public HSProgressOptions title(String title){
            this.title=title;
            return this;
        }

        public HSProgressOptions titleTextColor(int titleTextColor){
            this.titleTextColor=titleTextColor;
            return this;
        }

        public HSProgressOptions transViewBackgroundColor(int transViewBackgroundColor){
            this.transViewBackgroundColor=transViewBackgroundColor;
            return this;
        }

        public HSProgressOptions radius(int radius){
            this.radius=radius;
            return this;
        }

        public HSProgressOptions animationOption(HSAnimationOptions animationOption){
            this.animationOption=animationOption;
            return this;
        }


        //return fully build object
        public HSProgressModel init() {
            return new HSProgressModel(this);
        }
    }

}
