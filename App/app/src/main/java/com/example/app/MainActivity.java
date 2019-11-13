package com.example.app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import static android.view.animation.AnimationUtils.loadAnimation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);

        Animation animation = loadAnimation(this,R.anim.slide_out);


        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG,"on start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mButton.setVisibility(View.INVISIBLE);
                startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mButton.setOnClickListener((view)->{

            mButton.startAnimation(animation);
        });

    }
}
