package com.aisiliu.animationtest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.aisiliu.animationtest.animation.Rotate3dAnimation;

/**
 * Created by aisi on 2018/2/25.
 * 用于显示View动画(平移,缩放,旋转,透明度动画)
 */

public class ViewActivity extends AppCompatActivity {

    private int ACTIVITY_ANIM = 0;

    private ImageView imageView,imageViewFrame;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        imageView = findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.aisi);

        imageViewFrame = findViewById(R.id.image_view_frame);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            Animation animation;
            Intent intent = getIntent();
            switch (intent.getIntExtra("viewType",0)){
                case 1:
                    animation = AnimationUtils.loadAnimation(ViewActivity.this,R.anim.animation_translate);
                    imageView.startAnimation(animation);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(ViewActivity.this,"位置不变",Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case 2:
                    animation = AnimationUtils.loadAnimation(ViewActivity.this,R.anim.animation_scale);
                    imageView.startAnimation(animation);
                    break;
                case 3:
                    animation = AnimationUtils.loadAnimation(ViewActivity.this,R.anim.animation_rotate);
                    imageView.startAnimation(animation);
                    break;
                case 4:
                    animation = AnimationUtils.loadAnimation(ViewActivity.this,R.anim.animation_alpha);
                    imageView.startAnimation(animation);
                    break;
                case 5:
                    animation = new Rotate3dAnimation(-180f, 180f,getWindowManager().getDefaultDisplay().getWidth() / 2,getWindowManager().getDefaultDisplay().getHeight() / 2,10f,true);
                    animation.setDuration(2000);
                    imageView.startAnimation(animation);
                    break;
                case 6:
                    imageView.setVisibility(View.INVISIBLE);
                    imageViewFrame.setBackgroundResource(R.drawable.frame_animation);
                    AnimationDrawable animationDrawable = (AnimationDrawable) imageViewFrame.getBackground();
                    animationDrawable.start();
                    break;
                case 8:
                    ACTIVITY_ANIM = 8;
                    break;
                case 9:
                    ACTIVITY_ANIM = 9;
                    break;
                default:
                    break;
            }

        }
    }

    @Override
    public void finish() {
        super.finish();
        if (ACTIVITY_ANIM == 8){
            overridePendingTransition(R.anim.anim_activity_enter,R.anim.anim_activity_exit);
        }else if (ACTIVITY_ANIM == 9){
            overridePendingTransition(R.anim.anim_activity_enter_scale,R.anim.anim_activity_exit_scale);
        }
    }
}
