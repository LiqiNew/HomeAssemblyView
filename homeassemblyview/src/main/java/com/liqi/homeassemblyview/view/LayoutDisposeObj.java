package com.liqi.homeassemblyview.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.liqi.Logger;
import com.liqi.fragment.BaseFragment;
import com.liqi.homeassemblyview.interfa.OnDataFactoryBrushIntoListener;
import com.liqi.homeassemblyview.interfa.OnDataListAddFactoryListener;

/**
 * 单个布局内部数据存取对象
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

    /**
     * 无参构造函数
     */
    public LayoutDisposeObj() {

    }

    /**
     * 有参构造函数
     * @param onDataFactoryBrushIntoListener  第三方对象刷进添加工厂集合数据接口
     */
    public LayoutDisposeObj(OnDataFactoryBrushIntoListener onDataFactoryBrushIntoListener) {
        mOnDataFactoryBrushIntoListener = onDataFactoryBrushIntoListener;
    }

    /**
     * 把当前对象刷进DataListAddFactory集合数据添加工厂集合中。
     * <p>
     *     调用此方法必须要把OnDataFactoryBrushIntoListener传输进来
     * </p>
     * @return
     */
    public OnDataListAddFactoryListener brushIntoList() {
        if (null != mOnDataFactoryBrushIntoListener) {
            return mOnDataFactoryBrushIntoListener.brushIntoList();
        }
        Logger.e("HomeAssemblyView", "第三方对象刷进添加工厂集合数据接口为空");
        return null;
    }

    /**获取当前界面title控件文本内容
     *
     * @return title控件文本内容
     */
    public String getTextString() {
        return textString;
    }

    /**赋值当前界面title控件文本内容
     *
     * @param textString title控件文本内容
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setTextString(String textString) {
        this.textString = textString;
        return this;
    }

    /**
     * 获取展示的Fragment
     * @return 展示的Fragment
     */
    public BaseFragment getBaseFragment() {
        return baseFragment;
    }

    /**设置展示的Fragment
     *
     * @param baseFragment 展示的Fragment
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setBaseFragment(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
        return this;
    }

    /**
     *  获取当前界面title控件文本字体颜色选择器
     *  <p>
     *      必须得在选择器里面用Enabled标签实现
     *  </p>
     * @return 文本字体颜色选择器
     */
    public ColorStateList getTextColorSelectorId() {
        return textColorSelector;
    }

    /**
     *  设置当前界面title控件文本字体颜色选择器
     *  <p>
     *      选择器必须得在选择器里面用Enabled标签实现
     *  </p>
     * @param textColorSelectorId 文本字体颜色选择器
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setTextColorSelectorId(ColorStateList textColorSelectorId) {
        this.textColorSelector = textColorSelectorId;
        return this;
    }

    /**获取当前界面title控件图片选择器
     *
     * @return 控件图片选择器
     */
    public Drawable getDrawableSelectorId() {
        return drawableSelector;
    }

    /**
     *  设置当前界面title控件图片选择器
     *  <p>
     *      选择器必须得在选择器里面用Enabled标签实现
     *  </p>
     * @param drawableSelectorId 控件图片选择器
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setDrawableSelectorId(Drawable drawableSelectorId) {
        this.drawableSelector = drawableSelectorId;
        return this;
    }

    /**获取当前界面title控件文本字体大小
     *
     * @return 文本字体大小
     */
    public int getTextSize() {
        return textSize;
    }

    /**
     * 设置当前界面title控件文本字体大小
     * @param textSize 文本字体大小（默认15）
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * 获取当前界面title控件图片跟字体的间距
     * @return 图片跟字体的间距
     */
    public int getTextDrawablePadding() {
        return textDrawablePadding;
    }

    /**
     * 设置当前界面title控件图片跟字体的间距
     * <p>
     *     上下间距
     * </p>
     * @param textDrawablePadding 图片跟字体的间距
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setTextDrawablePadding(int textDrawablePadding) {
        this.textDrawablePadding = textDrawablePadding;
        return this;
    }

    /** 获取当前界面title控件左边偏距间距
     *
     * @return 左边偏距间距
     */
    public int getTextPaddingLeft() {
        return textPaddingLeft;
    }

    /**
     * 设置当前界面title控件左边偏距间距
     * @param textPaddingLeft 左边偏距间距
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setTextPaddingLeft(int textPaddingLeft) {
        this.textPaddingLeft = textPaddingLeft;
        return this;
    }

    /**
     * 获取当前界面title控件顶部偏距间距
     * @return 顶部偏距间距
     */
    public int getTextPaddingTop() {
        return textPaddingTop;
    }

    /**
     * 设置当前界面title控件顶部偏距间距
     * @param textPaddingTop 顶部偏距间距
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setTextPaddingTop(int textPaddingTop) {
        this.textPaddingTop = textPaddingTop;
        return this;
    }

    /**
     * 获取当前界面title控件右边偏距间距
     * @return 右边偏距间距
     */
    public int getTextPaddingRight() {
        return textPaddingRight;
    }

    /**
     * 设置当前界面title控件右边偏距间距
     * @param textPaddingRight 右边偏距间距
     * @return LayoutDisposeObj
     */
    public LayoutDisposeObj setTextPaddingRight(int textPaddingRight) {
        this.textPaddingRight = textPaddingRight;
        return this;
    }

    /**获取当前界面title控件底部偏距间距
     *
     * @return 底部偏距间距
     */
    public int getTextPaddingBottom() {
        return textPaddingBottom;
    }

    /**
     * 设置当前界面title控件底部偏距间距
     * @param textPaddingBottom 底部偏距间距
     * @return LayoutDisposeObj
     */
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
