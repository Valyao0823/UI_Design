package com.example.hesolutions.demoui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * Created by hesolutions on 2016-05-11.
 */
public class FunctionNumberPicker extends NumberPicker{

    public FunctionNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    private void updateView(View view) {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "robotb.ttf");
        if(view instanceof EditText){
            ((EditText) view).setTextSize(25);
            ((EditText) view).setTypeface(typeface);
        }
    }

}
