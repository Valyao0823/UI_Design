package com.example.hesolutions.demoui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class LeftSector extends MainActivity {
    Button goback, gomain, gofunction, goreport;
    TextClock currentyear, currentday, currentime;
    TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_sector);
        goback = (Button)findViewById(R.id.goback);
        gomain = (Button)findViewById(R.id.gomain);
        gofunction = (Button)findViewById(R.id.gofunction);
        basefloorplan = (ImageView)findViewById(R.id.basefloorplan);
        currentday = (TextClock)findViewById(R.id.currenday);
        currentyear = (TextClock)findViewById(R.id.currentyear);
        currentime = (TextClock)findViewById(R.id.currentime);
        goreport = (Button)findViewById(R.id.goreport);
        logo = (TextView)findViewById(R.id.logo);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "robots.ttf");
        logo.setTypeface(typeface);
        currentyear.setTypeface(typeface);
        currentday.setTypeface(typeface);
        currentime.setTypeface(typeface);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(LeftSector.this, R.anim.zoom_out);
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

                Intent intent = new Intent(LeftSector.this, ReportPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });

        gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(LeftSector.this, R.anim.zoom_out);
                basefloorplan.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LeftSector.this, MainActivity.class);
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

                Intent intent = new Intent(LeftSector.this, FunctionalPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
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
