package com.tanim.ibrar.fingergesture;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements Custom_Touch_Event.OnFling_right_left {

    Custom_Touch_Event customTouchEvent;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    ImageView twoFingerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.ll_animation_finger_usercreate);
        twoFingerImage = (ImageView) findViewById(R.id.animation_finger_usercreate);
        customTouchEvent = new Custom_Touch_Event(this);
        linearLayout = (LinearLayout) findViewById(R.id.fling_space_ll);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (customTouchEvent != null)
                    customTouchEvent.onTouch(v, event);
                return true;
            }
        });

        animation();
    }

    @Override
    public void flingRL_happened(boolean editOn) {

        if (editOn) {
            twoFingerImage.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.GONE);
            twoFingerImage.clearAnimation();

        } else {
            Toast.makeText(MainActivity.this, "Sorry!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void animation() {
        TranslateAnimation animation = new TranslateAnimation(-600.0f, 0.0f, 0.0f, 0.0f);
        animation.setDuration(3000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(1);
        twoFingerImage.setVisibility(View.VISIBLE);
        twoFingerImage.startAnimation(animation);
    }

}
