package com.example.nokiawzn;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ObjectAnimator mAnimatorMoveRight;
    ObjectAnimator mAnimatorMoveLeft;
    ObjectAnimator mAnimatorFade1,mAnimatorFade2,mAnimatorFade3;
    ObjectAnimator mAnimatorFadeIn1, mAnimatorFadeIn2, mAnimatorFadeIn3;
    MediaPlayer music;
    Button btn_animate;

    private AnimatorSet animatorSet = new AnimatorSet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView imgLeft = findViewById(R.id.left_img);
        ImageView imgRight = findViewById(R.id.right_img);
        ImageView logo = findViewById(R.id.nokia_logo);
//        btn_animate = findViewById(R.id.btn_animate);
        ImageView wiz = findViewById(R.id.turuu);

        mAnimatorFadeIn1 = ObjectAnimator.ofFloat(imgLeft,"alpha",1);
        mAnimatorFadeIn2 = ObjectAnimator.ofFloat(imgRight,"alpha",1);
        mAnimatorFadeIn3 = ObjectAnimator.ofFloat(logo,"alpa",1);
        mAnimatorFade1 = ObjectAnimator.ofFloat(imgLeft,"alpha",0);
        mAnimatorFade2 = ObjectAnimator.ofFloat(imgRight,"alpha",0);
        mAnimatorFade3 = ObjectAnimator.ofFloat(logo,"alpha",0);

        mAnimatorMoveLeft = ObjectAnimator.ofFloat(imgLeft,"x",-100);
        mAnimatorMoveRight = ObjectAnimator.ofFloat(imgRight,"x",100);
        music = MediaPlayer.create(MainActivity.this, R.raw.nokia);

        setContentView(R.layout.activity_main);

        wiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.play(mAnimatorFade1).with(mAnimatorFade2).before(mAnimatorFadeIn1).with(mAnimatorFadeIn2).before(mAnimatorMoveLeft)
                        .with(mAnimatorMoveRight).before(mAnimatorFade3).before(mAnimatorFadeIn3);
                animatorSet.start();
                music.start();
            }
        });


    }



}