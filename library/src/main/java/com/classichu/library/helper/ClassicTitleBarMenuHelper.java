package com.classichu.library.helper;

import android.support.v7.widget.PopupMenu;
import android.view.View;

/**
 * Created by louisgeek on 2017/2/28.
 */

public class ClassicTitleBarMenuHelper {

    private static PopupMenu mPopupMenu;
    public static void initMenu(View anchorView, int menuResId) {
        //
        mPopupMenu = new PopupMenu(anchorView.getContext(), anchorView);
        mPopupMenu.getMenuInflater().inflate(menuResId, mPopupMenu.getMenu());
        mPopupMenu.show();
    }
    public static void setOnMenuItemClickListener(OnClassicTitleBarMenuItemClickListener listener) {
        if (mPopupMenu != null) {
            mPopupMenu.setOnMenuItemClickListener(listener);
        }
    }
    public interface OnClassicTitleBarMenuItemClickListener extends PopupMenu.OnMenuItemClickListener{

    }
}
