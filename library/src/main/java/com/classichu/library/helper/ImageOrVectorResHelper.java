package com.classichu.library.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;

/**
 * Created by louisgeek on 2017/2/20.
 */

public class ImageOrVectorResHelper {
    public static Drawable getDrawable(Context context, int imageOrVectorResId) {
        /**
         * 自动处理VectorDrawable  or  Image  否则5.0以下使用Vector会报错
         */
        Drawable drawable = AppCompatDrawableManager.get().getDrawable(context, imageOrVectorResId);
        return drawable;
    }
}
