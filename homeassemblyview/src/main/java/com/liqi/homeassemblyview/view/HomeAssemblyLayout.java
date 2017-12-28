package com.liqi.homeassemblyview.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liqi.Logger;
import com.liqi.fragment.BaseFragment;
import com.liqi.homeassemblyview.R;
import com.liqi.homeassemblyview.adapter.ViewPagerAdapter;
import com.liqi.homeassemblyview.enums.LocationShow;
import com.liqi.homeassemblyview.factory.WidgetFactory;
import com.liqi.homeassemblyview.interfa.OnDataListAddFactoryListener;

import java.util.ArrayList;

/**
 * 组合首页布局
 *
 * @author Liqi
 */
public class HomeAssemblyLayout extends LinearLayout implements
        OnPageChangeListener, View.OnClickListener {
    private final String TAG = "HomeAssemblyView";
    private ViewpagerCustom mLayouwPager;
    private LinearLayout mLayoutAdd;
    private ViewPagerAdapter<LayoutDisposeObj> pagerAdapter;

    public HomeAssemblyLayout(Context context, AttributeSet attrs,
                              int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        ini(context);
    }

    public HomeAssemblyLayout(Context context, AttributeSet attrs,
                              int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ini(context);
    }

    public HomeAssemblyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        ini(context);
    }

    public HomeAssemblyLayout(Context context) {
        super(context);
        ini(context);
    }

    private void ini(Context context) {
        View.inflate(context, R.layout.home_assembly_layout, this);
        mLayouwPager = (ViewpagerCustom) findViewById(R.id.layout_pager);
        mLayouwPager.addOnPageChangeListener(this);
        mLayoutAdd = (LinearLayout) findViewById(R.id.layout_add_bottom);
    }

    /**
     * 布局开始装载(最先调用)
     *
     * @param getListListener 参数对象集合获取接口
     * @param loadPagerCount  预先加载页面数量
     *                        <p>
     *                        如果设置的loadPagerCount预先加载数量大于页面list长度的话，
     *                        就自动设置页面list长度为预先加载数量
     *                        </p>
     * @param fm              碎片管理者
     * @param location        标题显示位置：LocationShow.LAYOUT_TOP=顶部显示,LAYOUT_BOTTOM=底部显示
     * @return HomeAssemblyLayout
     */
    public HomeAssemblyLayout startLayout(
            OnDataListAddFactoryListener.OnDataGetListListener getListListener, int loadPagerCount,
            FragmentManager fm, LocationShow location) {
        if (null != getListListener) {
            ArrayList<LayoutDisposeObj> listLayout = getListListener.getListLayout();
            if (!listLayout.isEmpty()) {
                // 如果标题父控件里面存在子控件,那么全部移除掉
                if (getTitleLayoutCount() > 0) {
                    mLayoutAdd.removeAllViews();
                }
                seLocationShow(location);
                // 安装标题控件
                for (int i = 0; i < listLayout.size(); i++) {
                    LayoutDisposeObj disposeObj = listLayout.get(i);
                    TextView textView = disposeObj
                            .installationTextView(WidgetFactory.getTextView(
                                    getContext(), 1));
                    textView.setOnClickListener(this);
                    textView.setId(i);
                    // 存储fragment父类对象
                    textView.setTag(disposeObj.getBaseFragment());
                    mLayoutAdd.addView(textView);
                }

                if (null == pagerAdapter) {
                    pagerAdapter = new ViewPagerAdapter<>(fm,
                            listLayout);
                    mLayouwPager.setAdapter(pagerAdapter);
                } else {
                    pagerAdapter.notifyDataRefresh(listLayout);
                }
                // 如果设置的loadPagerCount预先加载数量大于页面list长度的话，就自动设置页面list长度为预先加载数量
                mLayouwPager.setOffscreenPageLimit(loadPagerCount > listLayout
                        .size() ? listLayout.size() : loadPagerCount);
            } else {
                Logger.e(TAG, "OnDataGetListListener接口获取集合数据为空");
            }
        } else {
            Logger.e(TAG, "OnDataGetListListener接口为空");
        }
        setTitleState(0);
        return this;
    }

    /**
     * 设置标题显示的位置
     *
     * @param location
     */
    private void seLocationShow(LocationShow location) {
        switch (location) {
            case LAYOUT_TOP:
                mLayoutAdd = (LinearLayout) findViewById(R.id.layout_add_top);
                findViewById(R.id.layout_top_view).setVisibility(View.VISIBLE);
                findViewById(R.id.layout_bottom_view).setVisibility(View.GONE);
                break;
            case LAYOUT_BOTTOM:
                mLayoutAdd = (LinearLayout) findViewById(R.id.layout_add_bottom);
                findViewById(R.id.layout_top_view).setVisibility(View.GONE);
                findViewById(R.id.layout_bottom_view).setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * 设置页面是否可以滑动
     *
     * @param why true是可以滑动，false是不能滑动。默认是true。
     * @return HomeAssemblyLayout
     */
    public HomeAssemblyLayout slideYesNo(boolean why) {
        if (null != mLayouwPager) {
            mLayouwPager.slideYesOrNo(why);
        }
        return this;
    }

    /**
     * 设置标题父布局Padding
     *
     * @param left 左Padding
     * @param top 上Padding
     * @param right 右Padding
     * @param bottom 下Padding
     * @return HomeAssemblyLayout
     */
    public HomeAssemblyLayout setSuperTitleLayoutPadding(int left, int top,
                                                         int right, int bottom) {
        if (null != mLayoutAdd) {
            mLayoutAdd.setPadding(left, top, right, bottom);
        }
        return this;
    }

    /**
     * 设置标题父布局背景Drawable
     *
     * @param background Drawable类型
     * @return HomeAssemblyLayout
     */
    public HomeAssemblyLayout setSuperTitleLayoutBackdrop(Drawable background) {
        if (null != mLayoutAdd) {
            mLayoutAdd.setBackgroundDrawable(background);
        }
        return this;
    }

    /**
     * 设置线条的颜色值
     *
     * @param color 线条的颜色值
     * @return HomeAssemblyLayout
     */
    public HomeAssemblyLayout setHintWire(@ColorRes int color) {
        findViewById(R.id.layout_top_view).setBackgroundColor(getResources().getColor(color));
        findViewById(R.id.layout_bottom_view).setBackgroundColor(getResources().getColor(color));
        return this;
    }

    /**
     * 设置标题父布局背景颜色
     *
     * @param resid 颜色资源ID
     * @return HomeAssemblyLayout
     */
    public HomeAssemblyLayout setSuperTitleLayoutBackdrop(@ColorRes int resid) {
        if (null != mLayoutAdd) {
            mLayoutAdd.setBackgroundResource(resid);
        }
        return this;
    }

    /**
     * 刷新当前显示的状态
     *
     * @param id
     */
    private void setTitleState(int id) {
        int childCount = getTitleLayoutCount();
        if (childCount > 0) {
            for (int j = 0; j < childCount; j++) {
                View childAt = mLayoutAdd.getChildAt(j);
                int viewId = childAt.getId();
                // 不是当前显示的ID
                if (viewId != id)
                    childAt.setEnabled(true);
                    // 当前显示的ID
                else {
                    childAt.setEnabled(false);
                    // 取出存储的Tag
                    BaseFragment baseFragment = (BaseFragment) childAt.getTag();
                    // 调用Tag存储对象的方法
                    baseFragment.onShow();
                }
            }
        }
    }

    /**
     * 获取标题布局里面的子控件数量
     *
     * @return
     */
    private int getTitleLayoutCount() {
        int childCount = 0;
        if (null != mLayoutAdd) {
            ViewGroup viewGroup = mLayoutAdd;
            childCount = viewGroup.getChildCount();
        }
        return childCount;
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int position) {
        setTitleState(position);
    }

    @Override
    public void onClick(View v) {
        mLayouwPager.setCurrentItem(v.getId());
    }
}
