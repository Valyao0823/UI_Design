package com.example.hesolutions.demoui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.ArrayList;


public class FunctionalPage extends Activity {
    ImageView backgroundimage;
    NumberPicker wheelView1, wheelView2, wheelView3;
    ArcProgress progressBar, daily, monthly;
    RelativeLayout testlayout;
    TextView text1, text2, text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functional_page);
        backgroundimage = (ImageView)findViewById(R.id.backgroundimage);
        wheelView1 = (NumberPicker)findViewById(R.id.wheelView1);
        wheelView2 = (NumberPicker)findViewById(R.id.wheelView2);
        wheelView3 = (NumberPicker)findViewById(R.id.wheelView3);
        progressBar = (ArcProgress)findViewById(R.id.progressBar);
        daily = (ArcProgress)findViewById(R.id.daily);
        monthly = (ArcProgress)findViewById(R.id.monthly);
        testlayout = (RelativeLayout)findViewById(R.id.testlayout);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "robots.ttf");
        text1.setTypeface(typeface);
        text2.setTypeface(typeface);
        text3.setTypeface(typeface);
        Bitmap cachedBitmap = DataBaseManager.getInstance().getBitmap();
        if (cachedBitmap != null) {
            Bitmap blurredBitmap = BlurBuilder.blur(this, cachedBitmap);
            backgroundimage.setBackground(new BitmapDrawable(getResources(), blurredBitmap));
        }

        backgroundimage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                //                if (x < 900 && x > 130 && y < 660 && y > 120){}else
                if (x < 880 && x > 160 && y < 670 && y > 60){}else
                {
                    finish();
                    overridePendingTransition(0, 0);
                }
                return false;
            }
        });


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

        wheelView1.setMinValue(0);
        wheelView1.setMaxValue(10);
        wheelView1.setValue(6);
        wheelView1.setDisplayedValues(intensityValue);
        wheelView1.setWrapSelectorWheel(false);
        wheelView1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


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
        wheelView2.setMinValue(1);
        wheelView2.setMaxValue(12);
        wheelView2.setValue(1);
        wheelView2.setDisplayedValues(windowinput);
        wheelView2.setWrapSelectorWheel(false);
        wheelView2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


        String[] huminput = new String[5];
        huminput[0] = "60%";
        huminput[1] = "70%";
        huminput[2] = "80%";
        huminput[3] = "90%";
        huminput[4] = "100%";
        wheelView3.setMinValue(1);
        wheelView3.setMaxValue(5);
        wheelView3.setValue(1);
        wheelView3.setDisplayedValues(huminput);
        wheelView3.setWrapSelectorWheel(false);
        wheelView3.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        wheelView1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int tem = wheelView2.getValue();
                int newvalue = (newVal * 5 + tem * 2);
                progressBar.setProgress(newvalue);
                int dayvalue = 50 + (int)(newvalue * 0.3);
                daily.setProgress(dayvalue);
                int yearvalue = 40 + (int)(dayvalue * 0.1);
                monthly.setProgress(yearvalue);
            }
        });

        wheelView2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int inten = wheelView1.getValue();
                int newvalue = (int) (newVal * 2 + inten * 5);
                progressBar.setProgress(newvalue);
                int dayvalue = 50 + (int)(newvalue * 0.3);
                daily.setProgress(dayvalue);
                int yearvalue = 40 + (int)(dayvalue * 0.1);
                monthly.setProgress(yearvalue);
            }
        });

        progressBar.setProgress(32);
        progressBar.setUnfinishedStrokeColor(getResources().getColor(R.color.thatblue));
        progressBar.setTextColor(getResources().getColor(R.color.thatblue));
        progressBar.setBottomText("Daily Energy");
        progressBar.setBottomTextSize(15);

        daily.setProgress(59);
        daily.setBottomText("Monthly Energy");
        daily.setUnfinishedStrokeColor(getResources().getColor(R.color.thatblue));
        daily.setTextColor(getResources().getColor(R.color.thatblue));
        daily.setBottomTextSize(12);

        monthly.setProgress(46);
        monthly.setBottomText("Yearly Energy");
        monthly.setUnfinishedStrokeColor(getResources().getColor(R.color.thatblue));
        monthly.setTextColor(getResources().getColor(R.color.thatblue));
        monthly.setBottomTextSize(12);
    }

}
