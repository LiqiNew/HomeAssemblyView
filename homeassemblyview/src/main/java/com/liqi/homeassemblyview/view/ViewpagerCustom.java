package com.liqi.homeassemblyview.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义Viewpager
 * 
 * @author Administrator
 * 
 */
public class ViewpagerCustom extends ViewPager {
	private boolean slide = true;

	public ViewpagerCustom(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ViewpagerCustom(Context context) {
		super(context);
	}

	/**
	 * 是否可以滑动
	 * 
	 * @param slide
	 */
	public void slideYesOrNo(boolean slide) {
		this.slide = slide;
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		if (slide)
			return super.onTouchEvent(arg0);
		else
			return slide;

	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if (slide)
			return super.onInterceptTouchEvent(arg0);
		else
			return slide;

	}
}
