package com.example.animation_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mainChar;
    boolean isLeft = false;

    ImageView enemy1;
    boolean enemy1_dead = false;
    ImageView enemy2;

    ImageView rightBullet;
    ImageView leftBullet;

    ImageButton btnLeft;
    ImageButton btnRight;
    ImageButton btnFire;

    ObjectAnimator leftAnim;
    ObjectAnimator rightAnim;

    ObjectAnimator rightBulletAnim;
    ObjectAnimator leftBulletAnim;

    ObjectAnimator enemyAnim1;
    ObjectAnimator enemyAnim2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainChar = findViewById(R.id.main_char);
        enemy1 = findViewById(R.id.enemy1);
        enemy2 = findViewById(R.id.enemy2);

        btnLeft = findViewById(R.id.btn_left);
        btnRight = findViewById(R.id.btn_right);
        btnFire = findViewById(R.id.btn_fire);

        rightBullet = findViewById(R.id.bullet_right);
        leftBullet = findViewById(R.id.bullet_left);

        //rotation, translationX, translationY
        leftAnim = ObjectAnimator.ofFloat(
                mainChar, "rotationY", 180);
        rightAnim = ObjectAnimator.ofFloat(
                mainChar, "rotationY", 0);
        rightBulletAnim = ObjectAnimator.ofFloat(
                rightBullet, "translationX", 700);
        leftBulletAnim = ObjectAnimator.ofFloat(
                leftBullet, "translationX", -700);

        enemyAnim1 = ObjectAnimator.ofFloat(
                enemy1, "translationX", -600);
        enemyAnim1.setDuration(20000);
        enemyAnim1.start();

        enemyAnim2 = ObjectAnimator.ofFloat(
                enemy2, "translationX", 600);
            enemyAnim2.setDuration(20000);
            enemyAnim2.start();




        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftAnim.setDuration(100);
                leftAnim.start();
                isLeft = true;
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightAnim.setDuration(100);
                rightAnim.start();
                isLeft = false;
            }
        });

        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isLeft){
                    rightBulletAnim.setDuration(100);
                    rightBulletAnim.start();
                    enemy1.setVisibility(View.INVISIBLE);
                    enemy1_dead = true;
//                    if(rightBullet.getX() == enemy1.getX()){
//                        enemy1.setVisibility(View.INVISIBLE);
//                    }

                }
                else{
                    leftBulletAnim.setDuration(100);
                    leftBulletAnim.start();
                    enemy2.setVisibility(View.INVISIBLE);
                }
            }
        });


    }
}