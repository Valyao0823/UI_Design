package com.example.hesolutions.demoui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class SuitePage extends Activity {
    Button goback, gomain, gofunction, goreport;
    Button light1, light2, light3, light4, light5, light6, camera, temp, window;
    ImageView basefloorplan;
    MyNumberPicker numberpicker, temppicker, windowpicker;
    TextView label, control;
    TextClock currentyear, currentday, currentime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suite_page);
        goback = (Button)findViewById(R.id.goback);
        goreport = (Button)findViewById(R.id.goreport);
        basefloorplan = (ImageView)findViewById(R.id.basefloorplan);
        gomain = (Button)findViewById(R.id.gomain);
        gofunction = (Button)findViewById(R.id.gofunction);
        numberpicker = (MyNumberPicker)findViewById(R.id.numberpicker);
        temppicker = (MyNumberPicker)findViewById(R.id.temppicker);
        windowpicker = (MyNumberPicker)findViewById(R.id.windowpicker);
        label = (TextView)findViewById(R.id.label);
        light1 = (Button)findViewById(R.id.light1);
        light2 = (Button)findViewById(R.id.light2);
        light3 = (Button)findViewById(R.id.light3);
        light4 = (Button)findViewById(R.id.light4);
        light5 = (Button)findViewById(R.id.light5);
        light6 = (Button)findViewById(R.id.light6);
        camera = (Button)findViewById(R.id.camera);
        temp = (Button)findViewById(R.id.temp);
        window = (Button)findViewById(R.id.window);
        control = (TextView)findViewById(R.id.control);
        currentday = (TextClock)findViewById(R.id.currenday);
        currentyear = (TextClock)findViewById(R.id.currentyear);
        currentime = (TextClock)findViewById(R.id.currentime);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "robots.ttf");
        Typeface typeface1 = Typeface.createFromAsset(this.getAssets(), "robotb.ttf");
        currentyear.setTypeface(typeface);
        currentday.setTypeface(typeface);
        currentime.setTypeface(typeface);
        label.setTypeface(typeface);
        control.setTypeface(typeface1);

        setBackGround();
        SetupDisplay();


        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
            }
        });

        gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuitePage.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        gofunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                View ScreenView = rootView.getRootView();
                ScreenView.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(ScreenView.getDrawingCache(), 0, 0, rootView.getWidth(),
                        ScreenView.getHeight());
                ScreenView.setDrawingCacheEnabled(false);
                DataBaseManager.getInstance().setBitmap(bitmap);

                Intent intent = new Intent(SuitePage.this, FunctionalPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        goreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                View ScreenView = rootView.getRootView();
                ScreenView.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(ScreenView.getDrawingCache(), 0, 0, rootView.getWidth(),
                        ScreenView.getHeight());
                ScreenView.setDrawingCacheEnabled(false);
                DataBaseManager.getInstance().setBitmap(bitmap);

                Intent intent = new Intent(SuitePage.this, ReportPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });

        numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String light = label.getText().toString();
                if (newVal > 0) {
                    switch (light) {
                        case "light1":
                            DataBaseManager.getInstance().setLight1(newVal);
                            light1.setBackground(getResources().getDrawable(R.drawable.lightunclick));
                            break;
                        case "light2":
                            DataBaseManager.getInstance().setLight2(newVal);
                            light2.setBackground(getResources().getDrawable(R.drawable.lightunclick));
                            break;
                        case "light3":
                            DataBaseManager.getInstance().setLight3(newVal);
                            light3.setBackground(getResources().getDrawable(R.drawable.lightunclick));
                            break;
                        case "light4":
                            DataBaseManager.getInstance().setLight4(newVal);
                            light4.setBackground(getResources().getDrawable(R.drawable.lightunclick));
                            break;
                        case "light5":
                            DataBaseManager.getInstance().setLight5(newVal);
                            light5.setBackground(getResources().getDrawable(R.drawable.lightunclick));
                            break;
                        case "light6":
                            DataBaseManager.getInstance().setLight6(newVal);
                            light6.setBackground(getResources().getDrawable(R.drawable.lightunclick));
                            break;
                        case "window":
                            window.setBackground(getResources().getDrawable(R.drawable.windowclick));
                            break;
                        case "temp":
                            temp.setBackground(getResources().getDrawable(R.drawable.tempclick));
                            break;
                    }
                }else
                {
                    switch (light) {
                        case "light1":
                            DataBaseManager.getInstance().setLight1(newVal);
                            light1.setBackground(getResources().getDrawable(R.drawable.lightclick));
                            break;
                        case "light2":
                            DataBaseManager.getInstance().setLight2(newVal);
                            light2.setBackground(getResources().getDrawable(R.drawable.lightclick));
                            break;
                        case "light3":
                            DataBaseManager.getInstance().setLight3(newVal);
                            light3.setBackground(getResources().getDrawable(R.drawable.lightclick));
                            break;
                        case "light4":
                            DataBaseManager.getInstance().setLight4(newVal);
                            light4.setBackground(getResources().getDrawable(R.drawable.lightclick));
                            break;
                        case "light5":
                            DataBaseManager.getInstance().setLight5(newVal);
                            light5.setBackground(getResources().getDrawable(R.drawable.lightclick));
                            break;
                        case "light6":
                            DataBaseManager.getInstance().setLight6(newVal);
                            light6.setBackground(getResources().getDrawable(R.drawable.lightclick));
                            break;
                        case "window":
                            window.setBackground(getResources().getDrawable(R.drawable.windowclick));
                            break;
                        case "temp":
                            temp.setBackground(getResources().getDrawable(R.drawable.tempclick));
                            break;
                    }
                }
            }
        });

        light1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Light"+"\n"+"Control");
                if (forLight("light1", 0)) {light1.setBackground(getResources().getDrawable(R.drawable.whitebold));}
                else {light1.setBackground(getResources().getDrawable(R.drawable.yellowbold));}
            }
        });
        light2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Light" + "\n" + "Control");
                if (forLight("light2", 1)) {light2.setBackground(getResources().getDrawable(R.drawable.whitebold));}else
                {light2.setBackground(getResources().getDrawable(R.drawable.yellowbold));}
            }
        });
        light3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Light" + "\n" + "Control");
                if (forLight("light3", 2)) {light3.setBackground(getResources().getDrawable(R.drawable.whitebold));}else
                {light3.setBackground(getResources().getDrawable(R.drawable.yellowbold));}
            }
        });
        light4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Light" + "\n" + "Control");
                if (forLight("light4", 3)) {light4.setBackground(getResources().getDrawable(R.drawable.whitebold));}else
                {light4.setBackground(getResources().getDrawable(R.drawable.yellowbold));}
            }
        });
        light5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Light" + "\n" + "Control");
                if (forLight("light5", 4)) {light5.setBackground(getResources().getDrawable(R.drawable.whitebold));}else
                {light5.setBackground(getResources().getDrawable(R.drawable.yellowbold));}
            }
        });
        light6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Light" + "\n" + "Control");
                if (forLight("light6", 5)) {light6.setBackground(getResources().getDrawable(R.drawable.whitebold));}else
                {light6.setBackground(getResources().getDrawable(R.drawable.yellowbold));}
            }
        });

        window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Window" + "\n" + "Control");
                if (forLight("window", 6)) {window.setBackground(getResources().getDrawable(R.drawable.opawhite));}else
                {window.setBackground(getResources().getDrawable(R.drawable.opawhite));}
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                control.setText("Temperature" + "\n" + "Control");
                if (forLight("temp", 7)) {temp.setBackground(getResources().getDrawable(R.drawable.temp));}else
                {temp.setBackground(getResources().getDrawable(R.drawable.temp));}
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackGround();
                numberpicker.setVisibility(View.INVISIBLE);
                temppicker.setVisibility(View.INVISIBLE);
                windowpicker.setVisibility(View.INVISIBLE);
                control.setText("Camera"+"\n"+"Control");
                control.setVisibility(View.VISIBLE);
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                View ScreenView = rootView.getRootView();
                ScreenView.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(ScreenView.getDrawingCache(), 0, 0, rootView.getWidth(),
                        ScreenView.getHeight());
                ScreenView.setDrawingCacheEnabled(false);
                DataBaseManager.getInstance().setBitmap(bitmap);

                Intent intent = new Intent(SuitePage.this, DisplayCamera.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });
    }

    public boolean forLight(String string, Integer integer){
        int intensity = DataBaseManager.getInstance().getLight(string);
        if (integer <= 5) {
            temppicker.setVisibility(View.INVISIBLE);
            windowpicker.setVisibility(View.INVISIBLE);
            if (label.getVisibility()== View.VISIBLE &&label.getText().toString().equals(string) && intensity > 0 && numberpicker.getVisibility() == View.VISIBLE) {
                numberpicker.setVisibility(View.INVISIBLE);
                control.setVisibility(View.INVISIBLE);
                DataBaseManager.getInstance().setLight(string, 0);
                return true;
            } else if (label.getVisibility()== View.VISIBLE &&label.getText().toString().equals(string)  && intensity > 0 && numberpicker.getVisibility() == View.INVISIBLE){
                numberpicker.setVisibility(View.VISIBLE);
                numberpicker.setValue(intensity);
                control.setVisibility(View.VISIBLE);
                return false;
            }else if (intensity > 0){
                label.setVisibility(View.VISIBLE);
                label.setText(string);
                numberpicker.setVisibility(View.VISIBLE);
                control.setVisibility(View.VISIBLE);
                numberpicker.setValue(intensity);
                return false;
            }else{
                label.setVisibility(View.VISIBLE);
                label.setText(string);
                numberpicker.setVisibility(View.VISIBLE);
                control.setVisibility(View.VISIBLE);
                numberpicker.setValue(intensity);
                return true;
            }
        }else if (integer == 6)
        {
            temppicker.setVisibility(View.INVISIBLE);
            numberpicker.setVisibility(View.INVISIBLE);
            if (label.getText().toString().equals(string) && numberpicker.getVisibility() == View.VISIBLE) {
                numberpicker.setVisibility(View.INVISIBLE);
                control.setVisibility(View.INVISIBLE);
                return false;
            } else {
                label.setVisibility(View.VISIBLE);
                label.setText(string);
                windowpicker.setVisibility(View.VISIBLE);
                control.setVisibility(View.VISIBLE);
                windowpicker.setValue(1);
                return true;
            }
        }else{
            windowpicker.setVisibility(View.INVISIBLE);
            numberpicker.setVisibility(View.INVISIBLE);
            if (label.getText().toString().equals(string) && numberpicker.getVisibility() == View.VISIBLE) {
                numberpicker.setVisibility(View.INVISIBLE);
                control.setVisibility(View.INVISIBLE);
                return false;
            } else {
                label.setVisibility(View.VISIBLE);
                label.setText(string);
                control.setVisibility(View.VISIBLE);
                temppicker.setVisibility(View.VISIBLE);
                temppicker.setValue(5);
                return true;
            }
        }
    }

    public void setBackGround()
    {
        if (DataBaseManager.getInstance().getLight1()>0) {light1.setBackground(getResources().getDrawable(R.drawable.lightunclick));}
        else {light1.setBackground(getResources().getDrawable(R.drawable.lightclick));}

        if (DataBaseManager.getInstance().getLight2()>0) {light2.setBackground(getResources().getDrawable(R.drawable.lightunclick));}
        else {light2.setBackground(getResources().getDrawable(R.drawable.lightclick));}

        if (DataBaseManager.getInstance().getLight3()>0) {light3.setBackground(getResources().getDrawable(R.drawable.lightunclick));}
        else {light3.setBackground(getResources().getDrawable(R.drawable.lightclick));}

        if (DataBaseManager.getInstance().getLight4()>0) {light4.setBackground(getResources().getDrawable(R.drawable.lightunclick));}
        else {light4.setBackground(getResources().getDrawable(R.drawable.lightclick));}

        if (DataBaseManager.getInstance().getLight5()>0) {light5.setBackground(getResources().getDrawable(R.drawable.lightunclick));}
        else {light5.setBackground(getResources().getDrawable(R.drawable.lightclick));}

        if (DataBaseManager.getInstance().getLight6()>0) {light6.setBackground(getResources().getDrawable(R.drawable.lightunclick));}
        else {light6.setBackground(getResources().getDrawable(R.drawable.lightclick));}
    }
    @Override
    public void onBackPressed() {}

    public void SetupDisplay(){

        String[] intensityValue = new String[11];
        intensityValue[0] = "0%";
        intensityValue[1] = "10%";
        intensityValue[2] = "20%";
        intensityValue[3] = "30%";
        intensityValue[4] = "40%";
        intensityValue[5] = "50%";
        intensityValue[6] = "60%";
        intensityValue[7] = "70%";
        intensityValue[8] = "80%";
        intensityValue[9] = "90%";
        intensityValue[10] = "100%";
        numberpicker.setMinValue(0);
        numberpicker.setMaxValue(10);
        numberpicker.setDisplayedValues(intensityValue);
        numberpicker.setWrapSelectorWheel(false);
        numberpicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        temppicker.setMaxValue(11);
        temppicker.setMinValue(0);
        String[] windowinput = new String[12];
        windowinput[0] = "16\u2103";
        windowinput[1] = "17\u2103";
        windowinput[2] = "18\u2103";
        windowinput[3] = "19\u2103";
        windowinput[4] = "20\u2103";
        windowinput[5] = "21\u2103";
        windowinput[6] = "22\u2103";
        windowinput[7] = "23\u2103";
        windowinput[8] = "24\u2103";
        windowinput[9] = "25\u2103";
        windowinput[10] = "26\u2103";
        windowinput[11] = "28\u2103";
        temppicker.setValue(5);
        temppicker.setDisplayedValues(windowinput);
        temppicker.setWrapSelectorWheel(false);
        temppicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


        windowpicker.setMinValue(0);
        windowpicker.setMaxValue(2);
        windowpicker.setValue(1);
        String[] temperinput = new String[3];
        temperinput[0] = "Level 1";
        temperinput[1] = "Level 2";
        temperinput[2] = "Level 3";
        windowpicker.setDisplayedValues(temperinput);
        windowpicker.setWrapSelectorWheel(false);
        windowpicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
    }
}
