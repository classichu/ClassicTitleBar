package com.classichu.titlebar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.classichu.titlebar.R;
import com.classichu.titlebar.helper.ImageOrVectorResHelper;
import com.classichu.titlebar.tool.SizeTool;

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

    private Drawable mLeftDrawable;
    private Drawable mCenterDrawable;
    private Drawable mRightDrawable;

    private boolean mLeftDrawableExchange;
    private boolean mCenterDrawableExchange;
    private boolean mRightDrawableExchange;

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
        mLeftDrawable = ImageOrVectorResHelper.getDrawable(getContext(), R.drawable.ic_arrow_back_black_24dp);
        setLeftImage();
        return this;
    }

    public ClassicTitleBar setRightImageClassicMore() {
        mRightDrawable = ImageOrVectorResHelper.getDrawable(getContext(), R.drawable.ic_more_vert_black_24dp);
        setRightImage();
        return this;
    }

    private void initAttrs(TypedArray typedArray) {

        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int index = typedArray.getIndex(i);
            //==================left and==============
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
                int defValue = getResources().getDimensionPixelSize(R.dimen.classic_text_size_primary);
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

            } else if (index == R.styleable.ClassicTitleBar_classic_leftDrawableExchange) {
                setLeftImageExchange(typedArray.getBoolean(index, false));
            } else if (index == R.styleable.ClassicTitleBar_classic_leftMaxWidth) {
                setLeftMaxWidth(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 100)));

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

            } else if (index == R.styleable.ClassicTitleBar_classic_rightDrawableExchange) {
                setRightImageExchange(typedArray.getBoolean(index, false));
            } else if (index == R.styleable.ClassicTitleBar_classic_rightMaxWidth) {
                setRightMaxWidth(typedArray.getDimensionPixelSize(index,
                        SizeTool.dp2px(getContext(), 100)));

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
                        SizeTool.dp2px(getContext(), 180)));

            } else if (index == R.styleable.ClassicTitleBar_classic_centerDrawableExchange) {
                setCenterImageExchange(typedArray.getBoolean(index, false));
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

    public ClassicTitleBar setRightImageExchange(boolean exchange) {
        mRightDrawableExchange = exchange;
        setRightImage();
        return this;
    }

    public ClassicTitleBar setCenterImageExchange(boolean exchange) {
        mCenterDrawableExchange = exchange;
        setCenterImage();
        return this;
    }

    public ClassicTitleBar setLeftImageExchange(boolean exchange) {
        mLeftDrawableExchange = exchange;
        setLeftImage();
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

    public ClassicTitleBar setCenterTextSize(int size) {
        mCenterText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        return this;
    }

    public ClassicTitleBar setLeftText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mLeftText.setText("");
            //
            if (mLeftDrawable == null) {
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
            if (mRightDrawable == null) {
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
            if (mCenterDrawable == null) {
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

    public ClassicTitleBar setRightImage(Drawable drawable) {
        mRightDrawable = drawable;
        setRightImage();
        return this;
    }

    public ClassicTitleBar setCenterImage(Drawable drawable) {
        mCenterDrawable = drawable;
        setCenterImage();
        return this;
    }

    public ClassicTitleBar setLeftImage(Drawable drawable) {
        mLeftDrawable = drawable;
        setLeftImage();
        return this;
    }

    private void setLeftImage() {
        if (mLeftDrawable != null) {
            if (TextUtils.isEmpty(mLeftText.getText())) {
                //
                mLeftText.setVisibility(GONE);
                mLeftText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                //
                mLeftImage.setVisibility(VISIBLE);
                mLeftImage.setImageDrawable(mLeftDrawable);
            } else {
                //
                mLeftText.setVisibility(VISIBLE);
                //mLeftText.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                mLeftDrawable.setBounds(0, 0, mLeftDrawable.getIntrinsicWidth(), mLeftDrawable.getIntrinsicHeight());
                if (mLeftDrawableExchange) {
                    mLeftText.setCompoundDrawables(null, null, mLeftDrawable, null);
                } else {
                    mLeftText.setCompoundDrawables(mLeftDrawable, null, null, null);
                }
                //
                mLeftImage.setVisibility(GONE);
            }
        } else {
            mLeftImage.setVisibility(GONE);
        }
    }

    private void setRightImage() {
        if (mRightDrawable != null) {
            if (TextUtils.isEmpty(mRightText.getText())) {
                //
                mRightText.setVisibility(GONE);
                mRightText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                //
                mRightImage.setVisibility(VISIBLE);
                mRightImage.setImageDrawable(mRightDrawable);
            } else {
                //
                mRightText.setVisibility(VISIBLE);
                //mRightText.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                mRightDrawable.setBounds(0, 0, mRightDrawable.getIntrinsicWidth(), mRightDrawable.getIntrinsicHeight());
                if (mRightDrawableExchange) {
                    mRightText.setCompoundDrawables(mRightDrawable, null, null, null);
                } else {
                    mRightText.setCompoundDrawables(null, null, mRightDrawable, null);
                }
                //
                mRightImage.setVisibility(GONE);
            }
        } else {
            mRightImage.setVisibility(GONE);
        }
    }

    private void setCenterImage() {
        if (mCenterDrawable != null) {
            if (TextUtils.isEmpty(mCenterText.getText())) {
                //
                mCenterText.setVisibility(GONE);
                mCenterText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                //
                mCenterImage.setVisibility(VISIBLE);
                mCenterImage.setImageDrawable(mCenterDrawable);
            } else {
                //
                mCenterText.setVisibility(VISIBLE);
                //mCenterText.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                mCenterDrawable.setBounds(0, 0, mCenterDrawable.getIntrinsicWidth(), mCenterDrawable.getIntrinsicHeight());
                if (mCenterDrawableExchange) {
                    mCenterText.setCompoundDrawables(mCenterDrawable, null, null, null);
                } else {
                    mCenterText.setCompoundDrawables(null, null, mCenterDrawable, null);
                }
                //
                mCenterImage.setVisibility(GONE);
            }
        } else {
            mCenterImage.setVisibility(GONE);
        }
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

        mLeftLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTitleBarLeftItemClickListener != null) {
                    mOnTitleBarLeftItemClickListener.onLeftClick(v);
                }
            }
        });
        mRightLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTitleBarRightItemClickListener != null) {
                    mOnTitleBarRightItemClickListener.onRightClick(v);
                }
            }
        });

        mCenterLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTitleBarCenterItemClickListener != null) {
                    mOnTitleBarCenterItemClickListener.onCenterClick(v);
                }
            }
        });

    }

    private OnTitleBarLeftItemClickListener mOnTitleBarLeftItemClickListener;
    private OnTitleBarRightItemClickListener mOnTitleBarRightItemClickListener;
    private OnTitleBarCenterItemClickListener mOnTitleBarCenterItemClickListener;

    public void setOnTitleBarLeftItemClickListener(OnTitleBarLeftItemClickListener listener) {
        mOnTitleBarLeftItemClickListener = listener;
    }

    public void setOnTitleBarRightItemClickListener(OnTitleBarRightItemClickListener listener) {
        mOnTitleBarRightItemClickListener = listener;
    }

    public void setOnTitleBarCenterItemClickListener(OnTitleBarCenterItemClickListener listener) {
        mOnTitleBarCenterItemClickListener = listener;
        //
        if (listener!=null){
            //设置点击反馈效果
            mCenterLayout.setBackgroundResource(R.drawable.selector_classic_nav_item_bg);
        }else{
            ViewCompat.setBackground(mCenterLayout,null);
        }
    }

    public interface OnTitleBarLeftItemClickListener {
        void onLeftClick(View view);
    }

    public interface OnTitleBarRightItemClickListener {
        void onRightClick(View view);
    }

    public interface OnTitleBarCenterItemClickListener {
        void onCenterClick(View view);
    }

}
