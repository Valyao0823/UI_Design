package com.example.hesolutions.demoui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class WaterPage extends Activity {

    ImageView backgroundimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_page);
        backgroundimage = (ImageView)findViewById(R.id.backgroundimage);
        Bitmap cachedBitmap = DataBaseManager.getInstance().getBitmap();

        if (cachedBitmap != null) {
            Bitmap blurredBitmap = BlurBuilder.blur(this, cachedBitmap);
            backgroundimage.setBackground(new BitmapDrawable(getResources(), blurredBitmap));
        }
        backgroundimage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int y = (int) event.getY();
                if (y < 600 && y > 140){}else
                {
                    finish();
                    overridePendingTransition(0, 0);
                }
                return false;
            }
        });
    }
}
