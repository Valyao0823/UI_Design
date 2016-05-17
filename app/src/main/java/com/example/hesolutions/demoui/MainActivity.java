package com.example.hesolutions.demoui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends Activity {
    ImageView basefloorplan, blurimgae;
    Button goback, gomain, gofunction, goreport, gowater;
    TextClock currentyear, currentday, currentime;
    TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basefloorplan = (ImageView)findViewById(R.id.basefloorplan);
        goback = (Button)findViewById(R.id.goback);
        gomain = (Button)findViewById(R.id.gomain);
        goreport = (Button)findViewById(R.id.goreport);
        gowater = (Button)findViewById(R.id.gowater);
        gofunction = (Button)findViewById(R.id.gofunction);
        blurimgae = (ImageView)findViewById(R.id.blurimage);
        currentday = (TextClock)findViewById(R.id.currenday);
        currentyear = (TextClock)findViewById(R.id.currentyear);
        currentime = (TextClock)findViewById(R.id.currentime);
        logo = (TextView)findViewById(R.id.logo);

        Typeface timefor = Typeface.createFromAsset(this.getAssets(), "robots.ttf");
        logo.setTypeface(timefor);
        currentyear.setTypeface(timefor);
        currentday.setTypeface(timefor);
        currentime.setTypeface(timefor);
        //basefloorplan.setMaxZoom(4f);
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

                Intent intent = new Intent(MainActivity.this, FunctionalPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });

        gowater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                View ScreenView = rootView.getRootView();
                ScreenView.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(ScreenView.getDrawingCache(), 0, 0, rootView.getWidth(),
                        ScreenView.getHeight());
                ScreenView.setDrawingCacheEnabled(false);
                DataBaseManager.getInstance().setBitmap(bitmap);

                Intent intent = new Intent(MainActivity.this, WaterPage.class);
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

                Intent intent = new Intent(MainActivity.this, ReportPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });

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
                        if (red == 255 && green == 207 && blue == 0) {
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in_left);
                            basefloorplan.startAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    Intent intent = new Intent(MainActivity.this, LeftSector.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });

                        } else if (red == 96 && green == 139 && blue == 50) {
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in_centre);
                            basefloorplan.startAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    Intent intent = new Intent(MainActivity.this, CentreSector.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });

                        } else if (red == 235 && green == 61 && blue == 0) {
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in_right);
                            basefloorplan.startAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {

                                    Intent intent = new Intent(MainActivity.this, RightSector.class);
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
