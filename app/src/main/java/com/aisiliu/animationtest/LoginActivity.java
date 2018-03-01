package com.aisiliu.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aisi on 2018/2/25.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText = findViewById(R.id.edit_text);
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(LoginActivity.this,R.anim.anim_password);
                editText.startAnimation(animation);
                Toast.makeText(LoginActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
