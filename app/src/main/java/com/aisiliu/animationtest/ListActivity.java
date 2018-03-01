package com.aisiliu.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by aisi on 2018/2/25.
 * 用于显示layoutAnimation动画作用于ViewGroup
 */

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.list_view);

        //创建子元素的动画
        Animation animation = AnimationUtils.loadAnimation(ListActivity.this,R.anim.anim_item);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        controller.setDelay(0.5f);

        listView.setLayoutAnimation(controller);

        //生成数据
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < 50; i++){
            data.add("item"+i);
        }

        //创建Adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.content_item,R.id.name,data);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,"你点击了item"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
