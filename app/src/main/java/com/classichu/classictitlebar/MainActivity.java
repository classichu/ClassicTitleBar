package com.classichu.classictitlebar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Toast;

import com.classichu.library.listener.OnNotFastClickListener;
import com.classichu.library.widget.ClassicTitleBar;

public class MainActivity extends AppCompatActivity {
    //开启vector
    static {
        /**
         * 可以正常使用Selector这样的DrawableContainers了。同时，
         * 你还开启了类似android:drawableLeft这样的compound drawable的使用权限，
         * 以及RadioButton的使用权限，以及ImageView’s src属性
         */
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    private ClassicTitleBar mClassicTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        findViewById(R.id.id_tv_next).setOnClickListener(new OnNotFastClickListener() {
            @Override
            protected void onNotFastClick(View v) {
                //
                startActivity(new Intent(MainActivity.this, NextActivity.class));
            }
        });


        mClassicTitleBar = (ClassicTitleBar) findViewById(R.id.id_classic_title_bar);
        mClassicTitleBar.setOnTitleBarItemClickListener(new ClassicTitleBar.OnTitleBarItemClickListener() {
            @Override
            public void onRightClick(View view) {
                super.onRightClick(view);
                Toast.makeText(MainActivity.this, "onRightClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
