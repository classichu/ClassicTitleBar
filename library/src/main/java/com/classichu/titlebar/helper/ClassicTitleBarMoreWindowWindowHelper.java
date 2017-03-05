package com.classichu.titlebar.helper;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by louisgeek on 2017/2/28.
 */

public class ClassicTitleBarMoreWindowWindowHelper {

    private static PopupWindow mPopupWindow;
    private static View mPopupWindowContentView;

    public static void setOnMoreWindowItemClickListener(int itemId, final OnMoreWindowItemClickListener listener) {
        mPopupWindowContentView.findViewById(itemId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                if (listener!=null){
                    listener.onMoreWindowItemClick(v);
                }
            }
        });
    }
    public  interface  OnMoreWindowItemClickListener{
       void onMoreWindowItemClick(View view);
    }

    public static void initMoreWindow(View anchorView, int moreWindowContentLayoutResId) {
        mPopupWindowContentView = LayoutInflater.from(anchorView.getContext()).inflate(moreWindowContentLayoutResId, null);
        mPopupWindow = new PopupWindow(mPopupWindowContentView);
        //
        mPopupWindowContentView .measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int realWidth=mPopupWindowContentView.getMeasuredWidth();
        // focusable 为true，PopupWindow的点击事件才会响应
        mPopupWindow.setFocusable(true);
        mPopupWindow.setWidth(realWidth==0?ViewGroup.LayoutParams.MATCH_PARENT:realWidth);
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
