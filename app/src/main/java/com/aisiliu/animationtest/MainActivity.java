package com.aisiliu.animationtest;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.aisiliu.animationtest.animation.Rotate3dAnimation;

public class MainActivity extends AppCompatActivity {

    private static final String viewType = "viewType";

    private Button button11,button12,button13,button14,button15;

    private boolean translation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    /**
     * 初始化View
     */
    private void initView(){
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);

        MyOnClickListener myOnClickListener = new MyOnClickListener();

        button1.setOnClickListener(myOnClickListener);
        button2.setOnClickListener(myOnClickListener);
        button3.setOnClickListener(myOnClickListener);
        button4.setOnClickListener(myOnClickListener);
        button5.setOnClickListener(myOnClickListener);
        button6.setOnClickListener(myOnClickListener);
        button7.setOnClickListener(myOnClickListener);
        button8.setOnClickListener(myOnClickListener);
        button9.setOnClickListener(myOnClickListener);
        button10.setOnClickListener(myOnClickListener);
        button11.setOnClickListener(myOnClickListener);
        button12.setOnClickListener(myOnClickListener);
        button13.setOnClickListener(myOnClickListener);
        button14.setOnClickListener(myOnClickListener);
        button15.setOnClickListener(myOnClickListener);
    }

    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()){
                //View动画-平移
                case R.id.button1:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,1);
                    startActivity(intent);
                    break;
                //View动画-缩放
                case R.id.button2:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,2);
                    startActivity(intent);
                    break;
                //View动画-旋转
                case R.id.button3:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,3);
                    startActivity(intent);
                    break;
                //View动画-透明度
                case R.id.button4:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,4);
                    startActivity(intent);
                    break;
                //自定义View动画
                case R.id.button5:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,5);
                    startActivity(intent);
                    break;
                    //帧动画
                case R.id.button6:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,6);
                    startActivity(intent);
                    break;
                    //View动画特殊场景-用于ViewGroup
                case R.id.button7:
                    intent.setClass(MainActivity.this,ListActivity.class);
                    startActivity(intent);
                    break;
                    //View动画特殊场景-用于Activity
                case R.id.button8:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,8);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_activity_enter,R.anim.anim_activity_exit);
                    break;
                    //View动画特殊场景-用于Activity
                case R.id.button9:
                    intent.setClass(MainActivity.this,ViewActivity.class);
                    intent.putExtra(viewType,9);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_activity_enter_scale,R.anim.anim_activity_exit_scale);
                    break;
                    //登录密码错误动画
                case R.id.button10:
                    intent.setClass(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
                    //属性动画-ObjectAnimator
                case R.id.button11:
                    if (translation){
                        ObjectAnimator.ofFloat(button11,"translationX",button11.getWidth() / 2).start();
                    }else{
                        ObjectAnimator.ofFloat(button11,"translationX",0).start();
                    }
                    translation = !translation;
                    break;
                //属性动画-ValueAnimator  Color.parseColor("#ff0000")
                case R.id.button12:
                    ValueAnimator colorAnim = ObjectAnimator.ofInt(button12,"backgroundColor", 0xFFFF8080,0xFF8080FF);
                    colorAnim.setDuration(3000);
                    //会根据当前进度计算当前的颜色
                    colorAnim.setEvaluator(new ArgbEvaluator());
                    //循环次数 infinite无限循环
                    colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                    //循环模式 reverse 反转(red-->blue-->red...)
                    colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                    colorAnim.start();
                    break;
                //属性动画-动画合集(playtogether同时播放)
                case R.id.button13:
                    AnimatorSet set = new AnimatorSet();
                    set.playTogether(ObjectAnimator.ofFloat(button13,"rotationX",0,360),
                            ObjectAnimator.ofFloat(button13,"rotationY",0,180),
                            ObjectAnimator.ofFloat(button13,"rotation",0,180),
                            ObjectAnimator.ofFloat(button13,"translationX",0,90),
                            ObjectAnimator.ofFloat(button13,"translationY",0,90),
                            ObjectAnimator.ofFloat(button13,"translationX",90,0),
                            ObjectAnimator.ofFloat(button13,"translationY",90,0),
                            ObjectAnimator.ofFloat(button13,"scaleX",1,1.5f),
                            ObjectAnimator.ofFloat(button13,"scaleY",1,1.5f),
                            ObjectAnimator.ofFloat(button13,"scaleX",1.5f,1.0f),
                            ObjectAnimator.ofFloat(button13,"scaleY",1.5f,1.0f),
                            ObjectAnimator.ofFloat(button13,"alpha",1,0.25f,1));
                    //动画集合总共耗费时间
                    set.setDuration(5*1000).start();
                    break;
                //
                case R.id.button14:
                    AnimatorSet set2 = new AnimatorSet();
                    set2.playSequentially(ObjectAnimator.ofFloat(button14,"rotationX",0,360),
                            ObjectAnimator.ofFloat(button14,"rotationY",0,180),
                            ObjectAnimator.ofFloat(button14,"rotation",0,-180),
                            ObjectAnimator.ofFloat(button14,"translationX",0,90),
                            ObjectAnimator.ofFloat(button14,"translationX",90,0),
                            ObjectAnimator.ofFloat(button14,"translationX",90,0),
                            ObjectAnimator.ofFloat(button14,"translationY",90,0),
                            ObjectAnimator.ofFloat(button14,"scaleX",1,1.5f),
                            ObjectAnimator.ofFloat(button14,"scaleY",1,1.5f),
                            ObjectAnimator.ofFloat(button14,"scaleX",1.5f,1.0f),
                            ObjectAnimator.ofFloat(button14,"scaleY",1.5f,1.0f),
                            ObjectAnimator.ofFloat(button14,"alpha",1,0.25f,1));
                    //和集中每个动画所需时间
                    set2.setDuration(500).start();
                    break;
                    //属性动画 xml形式
                case R.id.button15:
                    AnimatorSet set3 = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(),R.animator.anim_together);
                    set3.setTarget(button15);
                    set3.start();
                    break;
                default:
                    break;
            }
        }
    }

}
