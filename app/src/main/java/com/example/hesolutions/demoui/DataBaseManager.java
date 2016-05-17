package com.example.hesolutions.demoui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by hesolutions on 2016-05-06.
 */
public class DataBaseManager {
    private static DataBaseManager mInstance;
    public static DataBaseManager getInstance() {
        if (mInstance == null) {
            mInstance = new DataBaseManager();
        }
        return mInstance;
    }

    public Bitmap bitmap;
    public Bitmap getBitmap(){return bitmap;}
    public Bitmap setBitmap(Bitmap bitmap){this.bitmap = bitmap; return bitmap;}

    public int light1;
    public int getLight1(){return  light1;}
    public int setLight1(int light1){this.light1 = light1; return light1;}

    public int light2;
    public int getLight2(){return  light2;}
    public int setLight2(int light1){this.light2 = light1; return light2;}

    public int light3;
    public int getLight3(){return  light3;}
    public int setLight3(int light1){this.light3 = light1; return light3;}

    public int light4;
    public int getLight4(){return  light4;}
    public int setLight4(int light1){this.light4 = light1; return light4;}

    public int light5;
    public int getLight5(){return  light5;}
    public int setLight5(int light1){this.light5 = light1; return light5;}

    public int light6;
    public int getLight6(){return  light6;}
    public int setLight6(int light1){this.light6 = light1; return light6;}

    public int getLight(String string){
        switch (string)
        {
            case "light1":return getLight1();
            case "light2":return getLight2();
            case "light3":return getLight3();
            case "light4":return getLight4();
            case "light5":return getLight5();
            case "light6":return getLight6();
        }
        return 0;
    }

    public int setLight(String string, int intensity){
        switch (string)
        {
            case "light1":return setLight1(intensity);
            case "light2":return setLight2(intensity);
            case "light3":return setLight3(intensity);
            case "light4":return setLight4(intensity);
            case "light5":return setLight5(intensity);
            case "light6":return setLight6(intensity);
        }
        return 0;
    }
}
