package com.classichu.library.helper;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import static android.R.attr.id;

/**
 * Created by louisgeek on 2017/2/28.
 */

public class ClassicTitleBarMenuWindowHelper {

    private static PopupWindow mPopupWindow;
    private static View mPopupWindowContentView;

    public static void setOnMenuItemClickListener(int itemId, final OnMenuItemClickListener listener) {
        mPopupWindowContentView.findViewById(itemId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (listener!=null){
                    listener.onMenuItemClick(v);
                }
            }
        });
    }
    public  interface  OnMenuItemClickListener{
       void onMenuItemClick(View view);
    }

    public static void initMenuWindow(View anchorView, int menuWindowContentLayoutResId) {
        mPopupWindowContentView = LayoutInflater.from(anchorView.getContext()).inflate(menuWindowContentLayoutResId, null);
        mPopupWindow = new PopupWindow(mPopupWindowContentView);
        //
        mPopupWindowContentView .measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int realWidth=mPopupWindowContentView.getMeasuredWidth();
        // focusable 为true，PopupWindow的点击事件才会响应
        mPopupWindow.setFocusable(true);
        mPopupWindow.setWidth(realWidth);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setContentView(mPopupWindowContentView);

        // 必须设置一下背景色，否则点击外面不会隐藏此弹窗
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setTouchable(true);
        // focusable 为false时，不执行则点击外面不会隐藏此弹窗
        //mPopWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(anchorView);
    }
}
