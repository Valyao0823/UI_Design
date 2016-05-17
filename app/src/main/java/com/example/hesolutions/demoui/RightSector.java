package com.example.hesolutions.demoui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class RightSector extends Activity {
    ImageView basefloorplan;
    Button goback, gomain, gofunction, goreport;
    TextClock currentyear, currentday, currentime;
    TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_sector);
        basefloorplan = (ImageView)findViewById(R.id.basefloorplan);
        goback = (Button)findViewById(R.id.goback);
        gomain = (Button)findViewById(R.id.gomain);
        gofunction = (Button)findViewById(R.id.gofunction);
        currentday = (TextClock)findViewById(R.id.currenday);
        goreport = (Button)findViewById(R.id.goreport);
        currentyear = (TextClock)findViewById(R.id.currentyear);
        logo = (TextView)findViewById(R.id.logo);
        currentime = (TextClock)findViewById(R.id.currentime);
        Typeface timefor = Typeface.createFromAsset(this.getAssets(), "robots.ttf");
        logo.setTypeface(timefor);
        currentyear.setTypeface(timefor);
        currentday.setTypeface(timefor);
        currentime.setTypeface(timefor);
        //basefloorplan.setImageResource(R.drawable.left);
        basefloorplan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int action = event.getAction();
                final int evX = (int) event.getX();
                final int evY = (int) event.getY();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        int touchColor = getHotspotColor(R.id.basefilter, evX, evY);
                        int red = Color.red(touchColor);
                        int green = Color.green(touchColor);
                        int blue = Color.blue(touchColor);
                        if (red == 73 && green == 45 && blue == 165) {

                            Animation animation = AnimationUtils.loadAnimation(RightSector.this, R.anim.zoom_sector);
                            basefloorplan.startAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {

                                    Intent intent = new Intent(RightSector.this, SuitePage.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });

                        }
                        break;
                } // end switch
                return true;
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

                Intent intent = new Intent(RightSector.this, ReportPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(RightSector.this, R.anim.zoom_out);
                basefloorplan.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish();
                        overridePendingTransition(0, 0);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(RightSector.this, R.anim.zoom_out);
                basefloorplan.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(RightSector.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
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

                Intent intent = new Intent(RightSector.this, FunctionalPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }

    public int getHotspotColor (int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        if (img == null) {
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
            if (hotspots == null) {
                return 0;
            } else {
                img.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }
    @Override
    public void onBackPressed() {}

    @Override
    public void onResume()
    {
        super.onResume();
        basefloorplan.clearAnimation();
    }
}
