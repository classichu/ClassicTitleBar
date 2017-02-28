package com.classichu.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.classichu.library.R;
import com.classichu.library.helper.ImageOrVectorResHelper;
import com.classichu.library.listener.OnNotFastClickListener;
import com.classichu.library.tool.SizeTool;

/**
 * Created by louisgeek on 2017/2/27.
 */

public class ClassicTitleBar extends RelativeLayout {

    private LinearLayout mLeftLayout;
    private LinearLayout mRightLayout;
    private LinearLayout mCenterLayout;
    private ImageView mLeftImage;
    private ImageView mRightImage;
    private ImageView mCenterImage;
    private TextView mLeftText;
    private TextView mRightText;
    private TextView mCenterText;

    public ClassicTitleBar(Context context) {
        this(context, null);
    }

    public ClassicTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClassicTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //
        init(context);
        //
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ClassicTitleBar);
        initAttrs(typedArray);
        typedArray.recycle();
        //
        initDefCfg();
    }

    private void initDefCfg() {
        //
       //### setBackgroundColor(Color.parseColor("#f8f8f8"));
    }

    public ClassicTitleBar setLeftImageClassicBack() {
        setLeftImage(ImageOrVectorResHelper.getDrawable(getContext(), R.drawable.ic_arrow_back_black_24dp));
        return this;
    }
    public ClassicTitleBar setRightImageClassicMore() {
        setRightImage(ImageOrVectorResHelper.getDrawable(getContext(), R.drawable.ic_more_vert_black_24dp));
        return this;
    }

    private void initAttrs(TypedArray typedArray) {

        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int index = typedArray.getIndex(i);
            if (index == R.styleable.ClassicTitleBar_classic_leftText) {
                setLeftText(typedArray.getText(index));

            } else if (index == R.styleable.ClassicTitleBar_classic_leftDrawable) {//Deprecated
                // Drawable drawable= typedArray.getDrawable(index);
                int resourceId = typedArray.getResourceId(index, R.drawable.ic_arrow_back_black_24dp);
                Drawable drawable = ImageOrVectorResHelper.getDrawable(getContext(), resourceId);
                setLeftImage(drawable);

            } else if (index == R.styleable.ClassicTitleBar_classic_leftAndRightTextColor) {
                setLeftAndRightTextColor(typedArray.getColor(index, Color.WHITE));

            } else if (index == R.styleable.ClassicTitleBar_classic_leftAndRightTextSize) {
                int defValue=getResources().getDimensionPixelSize(R.dimen.classic_text_size_primary);
                /**
                 * getDimension和getDimensionPixelOffset差不多，前者返回float，后者返回int
                 * 如果单位是dp或sp，则需要将其乘以density。如果是px，则不乘。
                 * 而getDimensionPixelSize则不管写的是dp，sp，px, 都会乘以denstiy.
                 */
                setLeftAndRightTextSize(typedArray.getDimensionPixelSize(index, defValue));

            } else if (index == R.styleable.ClassicTitleBar_classic_leftAndRightPadding) {
                setLeftAndRightPadding(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 10)));

            } else if (index == R.styleable.ClassicTitleBar_classic_leftDrawablePadding) {
                mLeftText.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 2)));

            } else if (index == R.styleable.ClassicTitleBar_classic_leftMaxWidth) {
                setLeftMaxWidth(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 80)));

                //==================right==============
            } else if (index == R.styleable.ClassicTitleBar_classic_rightText) {
                setRightText(typedArray.getText(index));

            } else if (index == R.styleable.ClassicTitleBar_classic_rightDrawable) {//Deprecated
                // Drawable drawable= typedArray.getDrawable(index);
                int resourceIdRight = typedArray.getResourceId(index, R.drawable.ic_more_vert_black_24dp);
                Drawable drawableRight = ImageOrVectorResHelper.getDrawable(getContext(), resourceIdRight);
                setRightImage(drawableRight);

            } else if (index == R.styleable.ClassicTitleBar_classic_rightDrawablePadding) {
                mRightText.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 2)));

            } else if (index == R.styleable.ClassicTitleBar_classic_rightMaxWidth) {
                setRightMaxWidth(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 80)));

                //==================center==============
            } else if (index == R.styleable.ClassicTitleBar_classic_centerText) {
                setCenterText(typedArray.getText(index));

            } else if (index == R.styleable.ClassicTitleBar_classic_centerDrawable) {//Deprecated
                // Drawable drawable= typedArray.getDrawable(index);
                int resourceIdCenter = typedArray.getResourceId(index, R.drawable.ic_more_vert_black_24dp);
                Drawable drawableCenter = ImageOrVectorResHelper.getDrawable(getContext(), resourceIdCenter);
                setCenterImage(drawableCenter);

            } else if (index == R.styleable.ClassicTitleBar_classic_centerDrawablePadding) {
                mCenterText.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 2)));

            } else if (index == R.styleable.ClassicTitleBar_classic_centerTextColor) {
                setCenterTextColor(typedArray.getColor(index, Color.WHITE));

            } else if (index == R.styleable.ClassicTitleBar_classic_centerTextSize) {
                int defValueCenter = getResources().getDimensionPixelSize(R.dimen.classic_text_size_big);
                /**
                 * getDimension和getDimensionPixelOffset差不多，前者返回float，后者返回int
                 * 如果单位是dp或sp，则需要将其乘以density。如果是px，则不乘。
                 * 而getDimensionPixelSize则不管写的是dp，sp，px, 都会乘以denstiy.
                 */
                setCenterTextSize(typedArray.getDimensionPixelSize(index, defValueCenter));

            } else if (index == R.styleable.ClassicTitleBar_classic_centerPadding) {
                setCenterPadding(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 10)));

            } else if (index == R.styleable.ClassicTitleBar_classic_centerMaxWidth) {
                setCenterMaxWidth(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 160)));

            }
        }
    }

    public ClassicTitleBar setCenterMaxWidth(int maxSize) {
        mCenterText.setMaxWidth(maxSize);
        return this;
    }

    public ClassicTitleBar setRightMaxWidth(int maxSize) {
        mRightText.setMaxWidth(maxSize);
        return this;
    }

    public ClassicTitleBar setLeftMaxWidth(int maxSize) {
        mLeftText.setMaxWidth(maxSize);
        return this;
    }

    public ClassicTitleBar setCenterTextSize(int size) {
        mCenterText.setTextSize(size);
        return this;
    }

    public ClassicTitleBar setCenterTextColor(int color) {
        mCenterText.setTextColor(color);
        return this;
    }

    public ClassicTitleBar setLeftAndRightPadding(int padding) {
        mLeftText.setPadding(padding, mLeftText.getPaddingTop(), padding, mLeftText.getPaddingBottom());
        mRightText.setPadding(padding, mRightText.getPaddingTop(), padding, mRightText.getPaddingBottom());
        return this;
    }

    public ClassicTitleBar setCenterPadding(int padding) {
        mCenterText.setPadding(padding, mCenterText.getPaddingTop(), padding, mCenterText.getPaddingBottom());
        return this;
    }

    public ClassicTitleBar setLeftAndRightTextColor(int color) {
        mLeftText.setTextColor(color);
        mRightText.setTextColor(color);
        return this;
    }

    /**
     * 默认是sp 改用个人常用的px
     *
     * @param size
     */
    public ClassicTitleBar setLeftAndRightTextSize(float size) {
        mLeftText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mRightText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        return this;
    }

    public ClassicTitleBar setLeftText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mLeftText.setText("");
            //
            if (mLeftText.getCompoundDrawables()[0] == null) {
                mLeftText.setVisibility(GONE);
            } else {
                mLeftText.setVisibility(VISIBLE);
            }
        } else {
            mLeftText.setText(text);
            //
            mLeftText.setVisibility(VISIBLE);
        }
        return this;
    }

    public ClassicTitleBar setRightText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mRightText.setText("");
            //
            if (mRightText.getCompoundDrawables()[2] == null) {
                mRightText.setVisibility(GONE);
            } else {
                mRightText.setVisibility(VISIBLE);
            }
        } else {
            mRightText.setText(text);
            //
            mRightText.setVisibility(VISIBLE);
        }
        return this;
    }

    public ClassicTitleBar setCenterText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mCenterText.setText("");
            //
            if (mCenterText.getCompoundDrawables()[0] == null) {
                mCenterText.setVisibility(GONE);
            } else {
                mCenterText.setVisibility(VISIBLE);
            }
        } else {
            mCenterText.setText(text);
            //
            mCenterText.setVisibility(VISIBLE);
        }
        return this;
    }

    public ClassicTitleBar setLeftImage(Drawable drawable) {
        if (drawable != null) {
            if (TextUtils.isEmpty(mLeftText.getText())) {
                //
                mLeftText.setVisibility(GONE);
                mLeftText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                //
                mLeftImage.setVisibility(VISIBLE);
                mLeftImage.setImageDrawable(drawable);
            } else {
                //
                mLeftText.setVisibility(VISIBLE);
                //mLeftText.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                mLeftText.setCompoundDrawables(drawable, null, null, null);
                //
                mLeftImage.setVisibility(GONE);
            }
        } else {
            mLeftImage.setVisibility(GONE);
        }
        return this;
    }

    public ClassicTitleBar setRightImage(Drawable drawable) {
        if (drawable != null) {
            if (TextUtils.isEmpty(mRightText.getText())) {
                //
                mRightText.setVisibility(GONE);
                mRightText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                //
                mRightImage.setVisibility(VISIBLE);
                mRightImage.setImageDrawable(drawable);
            } else {
                //
                mRightText.setVisibility(VISIBLE);
                //mLeftText.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                mRightText.setCompoundDrawables(null, null, drawable, null);
                //
                mRightImage.setVisibility(GONE);
            }
        } else {
            mRightImage.setVisibility(GONE);
        }
        return this;
    }

    public ClassicTitleBar setCenterImage(Drawable drawable) {
        if (drawable != null) {
            if (TextUtils.isEmpty(mCenterText.getText())) {
                //
                mCenterText.setVisibility(GONE);
                mCenterText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                //
                mCenterImage.setVisibility(VISIBLE);
                mCenterImage.setImageDrawable(drawable);
            } else {
                //
                mCenterText.setVisibility(VISIBLE);
                //mLeftText.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                mCenterText.setCompoundDrawables(drawable, null, null, null);
                //
                mCenterImage.setVisibility(GONE);
            }
        } else {
            mCenterImage.setVisibility(GONE);
        }
        return this;
    }

    private void init(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_classic_title_bar, this, true);


        mLeftLayout = (LinearLayout) view.findViewById(R.id.id_ll_left);
        mCenterLayout = (LinearLayout) view.findViewById(R.id.id_ll_center);
        mRightLayout = (LinearLayout) view.findViewById(R.id.id_ll_right);

        mLeftImage = (ImageView) view.findViewById(R.id.id_iv_left);
        mRightImage = (ImageView) view.findViewById(R.id.id_iv_right);
        mCenterImage = (ImageView) view.findViewById(R.id.id_iv_center);

        mLeftText = (TextView) view.findViewById(R.id.id_tv_left);
        mRightText = (TextView) view.findViewById(R.id.id_tv_right);
        mCenterText = (TextView) view.findViewById(R.id.id_tv_center);

        mLeftLayout.setOnClickListener(new OnNotFastClickListener() {
            @Override
            protected void onNotFastClick(View v) {
                if (mOnTitleBarItemClickListener != null) {
                    mOnTitleBarItemClickListener.onLeftClick(v);
                }
            }
        });
        mRightLayout.setOnClickListener(new OnNotFastClickListener() {
            @Override
            protected void onNotFastClick(View v) {
                if (mOnTitleBarItemClickListener != null) {
                    mOnTitleBarItemClickListener.onRightClick(v);
                }
            }
        });
        mCenterLayout.setOnClickListener(new OnNotFastClickListener() {
            @Override
            protected void onNotFastClick(View v) {
                if (mOnTitleBarItemClickListener != null) {
                    mOnTitleBarItemClickListener.onCenterClick(v);
                }
            }
        });

    }

    private OnTitleBarItemClickListener mOnTitleBarItemClickListener;

    public void setOnTitleBarItemClickListener(OnTitleBarItemClickListener onTitleBarItemClickListener) {
        mOnTitleBarItemClickListener = onTitleBarItemClickListener;
    }

    public static abstract class OnTitleBarItemClickListener {
        public void onLeftClick(View view) {

        }

        public void onRightClick(View view) {

        }

        public void onCenterClick(View view) {

        }
    }

}
