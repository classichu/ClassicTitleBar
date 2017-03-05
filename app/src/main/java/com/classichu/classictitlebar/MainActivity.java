package com.classichu.classictitlebar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.classichu.titlebar.helper.ClassicTitleBarMenuHelper;
import com.classichu.titlebar.helper.ClassicTitleBarMoreWindowWindowHelper;
import com.classichu.titlebar.widget.ClassicTitleBar;

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

        mClassicTitleBar = (ClassicTitleBar) findViewById(R.id.id_classic_title_bar);
        mClassicTitleBar.setOnTitleBarCenterItemClickListener(new ClassicTitleBar.OnTitleBarCenterItemClickListener() {
            @Override
            public void onCenterClick(View view) {
                Toast.makeText(MainActivity.this, "onCenterClick", Toast.LENGTH_SHORT).show();
            }
        });
        mClassicTitleBar.setOnTitleBarRightItemClickListener(new ClassicTitleBar.OnTitleBarRightItemClickListener() {
            @Override
            public void onRightClick(View view) {
                //
                ClassicTitleBarMenuHelper.initMenu(view, R.menu.menu_title_bar);
                ClassicTitleBarMenuHelper.setOnMenuItemClickListener(new ClassicTitleBarMenuHelper.OnClassicTitleBarMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.id_menu_next:
                                Toast.makeText(MainActivity.this, "id_menu_next", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.id_menu_share:
                                Toast.makeText(MainActivity.this, "id_menu_share", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
            }
        });


        ClassicTitleBar classicTitleBar2 = (ClassicTitleBar) findViewById(R.id.id_classic_title_bar2);
        classicTitleBar2.setOnTitleBarRightItemClickListener(new ClassicTitleBar.OnTitleBarRightItemClickListener() {
            @Override
            public void onRightClick(View view) {
                //
                ClassicTitleBarMoreWindowWindowHelper.initMoreWindow(view, R.layout.layout_title_bar_menu_window);
                ClassicTitleBarMoreWindowWindowHelper.setOnMoreWindowItemClickListener(R.id.id_btn_next, new ClassicTitleBarMoreWindowWindowHelper.OnMoreWindowItemClickListener() {
                    @Override
                    public void onMoreWindowItemClick(View view) {
                        Toast.makeText(MainActivity.this, "id_btn_next", Toast.LENGTH_SHORT).show();
                    }
                });
                ClassicTitleBarMoreWindowWindowHelper.setOnMoreWindowItemClickListener(R.id.id_btn_share, new ClassicTitleBarMoreWindowWindowHelper.OnMoreWindowItemClickListener() {
                    @Override
                    public void onMoreWindowItemClick(View view) {
                        Toast.makeText(MainActivity.this, "id_btn_share", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
