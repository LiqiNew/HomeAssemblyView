package com.liqi.homeassemblyview.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.liqi.Logger;
import com.liqi.fragment.BaseFragment;
import com.liqi.homeassemblyview.interfa.OnDataFactoryBrushIntoListener;
import com.liqi.homeassemblyview.interfa.OnDataListAddFactoryListener;

/**
 * 布局数据获取和控件内容设置对象
 *
 * @author Liqi
 */
public class LayoutDisposeObj {
    // 展示的fragment
    private BaseFragment baseFragment;
    // 字体颜色选择器>>必须得在选择器里面用Enabled标签实现
    private ColorStateList textColorSelector;
    // 图片选择器>>必须得在选择器里面用Enabled标签实现
    private Drawable drawableSelector;
    // 字体大小（默认15）
    private int textSize = 15;
    // 图片跟字体的间距
    private int textDrawablePadding;
    // 左边偏距间距
    private int textPaddingLeft;
    // 顶部偏距间距
    private int textPaddingTop;
    // 右边偏距间距
    private int textPaddingRight;
    // 底部偏距间距
    private int textPaddingBottom;
    //控件内容
    private String textString;
    //第三方对象刷进添加工厂集合数据接口
    private OnDataFactoryBrushIntoListener mOnDataFactoryBrushIntoListener;

    public LayoutDisposeObj() {

    }

    public LayoutDisposeObj(OnDataFactoryBrushIntoListener onDataFactoryBrushIntoListener) {
        mOnDataFactoryBrushIntoListener = onDataFactoryBrushIntoListener;
    }

    public OnDataListAddFactoryListener brushIntoList() {
        if (null != mOnDataFactoryBrushIntoListener) {
            return mOnDataFactoryBrushIntoListener.brushIntoList();
        }
        Logger.e("HomeAssemblyView", "第三方对象刷进添加工厂集合数据接口为空");
        return null;
    }

    public String getTextString() {
        return textString;
    }

    public LayoutDisposeObj setTextString(String textString) {
        this.textString = textString;
        return this;
    }

    public BaseFragment getBaseFragment() {
        return baseFragment;
    }

    public LayoutDisposeObj setBaseFragment(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
        return this;
    }

    public ColorStateList getTextColorSelectorId() {
        return textColorSelector;
    }

    public LayoutDisposeObj setTextColorSelectorId(ColorStateList textColorSelectorId) {
        this.textColorSelector = textColorSelectorId;
        return this;
    }

    public Drawable getDrawableSelectorId() {
        return drawableSelector;
    }

    public LayoutDisposeObj setDrawableSelectorId(Drawable drawableSelectorId) {
        this.drawableSelector = drawableSelectorId;
        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public LayoutDisposeObj setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public int getTextDrawablePadding() {
        return textDrawablePadding;
    }

    public LayoutDisposeObj setTextDrawablePadding(int textDrawablePadding) {
        this.textDrawablePadding = textDrawablePadding;
        return this;
    }

    public int getTextPaddingLeft() {
        return textPaddingLeft;
    }

    public LayoutDisposeObj setTextPaddingLeft(int textPaddingLeft) {
        this.textPaddingLeft = textPaddingLeft;
        return this;
    }

    public int getTextPaddingTop() {
        return textPaddingTop;
    }

    public LayoutDisposeObj setTextPaddingTop(int textPaddingTop) {
        this.textPaddingTop = textPaddingTop;
        return this;
    }

    public int getTextPaddingRight() {
        return textPaddingRight;
    }

    public LayoutDisposeObj setTextPaddingRight(int textPaddingRight) {
        this.textPaddingRight = textPaddingRight;
        return this;
    }

    public int getTextPaddingBottom() {
        return textPaddingBottom;
    }

    public LayoutDisposeObj setTextPaddingBottom(int textPaddingBottom) {
        this.textPaddingBottom = textPaddingBottom;
        return this;
    }

    /**
     * 装置传过来的TextView控件
     *
     * @param textView
     */
    TextView installationTextView(TextView textView) {
        if (null != textView) {
            if (null != textColorSelector)
                textView.setTextColor(textColorSelector);
            if (null != drawableSelector) {
                drawableSelector.setBounds(0, 0,
                        drawableSelector.getMinimumWidth(),
                        drawableSelector.getMinimumHeight());
                textView.setCompoundDrawables(null, drawableSelector, null,
                        null);
                textView.setCompoundDrawablePadding(textDrawablePadding);
            }
            textView.setTextSize(textSize);
            textView.setPadding(textPaddingLeft, textPaddingTop,
                    textPaddingRight, textPaddingBottom);
            textView.setText(textString);
        }
        return textView;
    }
}
