package com.classichu.classictitlebar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.classichu.library.helper.ImageOrVectorResHelper;
import com.classichu.library.widget.ClassicTitleBar;

public class NextActivity extends AppCompatActivity {

    private ClassicTitleBar mClassicTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mClassicTitleBar = (ClassicTitleBar) findViewById(R.id.id_classic_title_bar);
        mClassicTitleBar
                .setRightImage(ImageOrVectorResHelper.getDrawable(this, R.drawable.ic_more_vert_black_24dp))
                .setCenterText("Classichu")
                .setOnTitleBarItemClickListener(new ClassicTitleBar.OnTitleBarItemClickListener() {
                    @Override
                    public void onLeftClick(View view) {
                        super.onLeftClick(view);
                        //
                        finish();
                        //  ActivityCompat.finishAfterTransition(NextActivity.this);
                    }
                });

    }
}
