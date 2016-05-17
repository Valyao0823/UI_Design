package com.example.hesolutions.demoui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hesolutions on 2016-05-12.
 */
public class HelveticaTextView extends TextView {
    public HelveticaTextView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "helvetica.ttf"));
    }
}
