package com.example.animation_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnAnimate;
    ObjectAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        btnAnimate = findViewById(R.id.btn_animate);
        mAnimator = ObjectAnimator.ofFloat(
                imageView, "rotation", 360);

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimator.setDuration(1000);
                mAnimator.start();
            }
        });
    }
}