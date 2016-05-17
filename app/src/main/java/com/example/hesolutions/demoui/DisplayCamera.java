package com.example.hesolutions.demoui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayCamera extends Activity {
    ImageView backgroundimage, motion, heat, playback, record;
    private Camera mCamera = null;
    private CameraView mCameraView = null;
    Button motionButton, liveButton, recordButton, heatButton, playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_camera);
        backgroundimage = (ImageView)findViewById(R.id.backgroundimage);
        motionButton = (Button)findViewById(R.id.motionButton);
        liveButton = (Button)findViewById(R.id.liveButton);
        recordButton = (Button)findViewById(R.id.recordButton);
        heatButton = (Button)findViewById(R.id.heatButton);
        motion = (ImageView)findViewById(R.id.motion);
        heat = (ImageView)findViewById(R.id.heat);
        record = (ImageView)findViewById(R.id.record);
        playback = (ImageView)findViewById(R.id.playback);
        playButton = (Button)findViewById(R.id.playButton);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "robots.ttf");
        liveButton.setTypeface(typeface);
        recordButton.setTypeface(typeface);
        heatButton.setTypeface(typeface);
        playButton.setTypeface(typeface);
        motionButton.setTypeface(typeface);
        backgroundimage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (x < 900 && x > 100 && y < 700 && y > 80){}else
                {
                    finish();
                    overridePendingTransition(0, 0);
                }

                return false;
            }
        });
        Bitmap cachedBitmap = DataBaseManager.getInstance().getBitmap();
        if (cachedBitmap != null) {
            Bitmap blurredBitmap = BlurBuilder.blur(this, cachedBitmap);
            backgroundimage.setBackground(new BitmapDrawable(getResources(), blurredBitmap));
        }
        try{
            mCamera = Camera.open();//you can use open(int) to use different cameras
        } catch (Exception e){
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if(mCamera != null) {
            mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.cameraView);
            camera_view.addView(mCameraView);//add the SurfaceView to the layout
        }

        motionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heat.setVisibility(View.INVISIBLE);
                playback.setVisibility(View.INVISIBLE);
                record.setVisibility(View.INVISIBLE);
                if (motion.getVisibility()==View.VISIBLE){
                    motion.setVisibility(View.INVISIBLE);
                }else {
                    motion.setVisibility(View.VISIBLE);
                }
            }
        });
        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motion.setVisibility(View.INVISIBLE);
                playback.setVisibility(View.INVISIBLE);
                heat.setVisibility(View.INVISIBLE);
                record.setVisibility(View.INVISIBLE);
            }
        });
        heatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motion.setVisibility(View.INVISIBLE);
                playback.setVisibility(View.INVISIBLE);
                record.setVisibility(View.INVISIBLE);
                if (heat.getVisibility()==View.VISIBLE){
                    heat.setVisibility(View.INVISIBLE);
                }else {
                    heat.setVisibility(View.VISIBLE);
                }
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motion.setVisibility(View.INVISIBLE);
                heat.setVisibility(View.INVISIBLE);
                record.setVisibility(View.INVISIBLE);
                if (playback.getVisibility()==View.VISIBLE){
                    playback.setVisibility(View.INVISIBLE);
                }else {
                    playback.setVisibility(View.VISIBLE);
                }
            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motion.setVisibility(View.INVISIBLE);
                heat.setVisibility(View.INVISIBLE);
                playback.setVisibility(View.INVISIBLE);
                if (record.getVisibility()==View.VISIBLE){
                    record.setVisibility(View.INVISIBLE);
                }else {
                    record.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
