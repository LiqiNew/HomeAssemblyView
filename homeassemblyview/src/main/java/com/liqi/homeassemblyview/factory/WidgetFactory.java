package com.liqi.homeassemblyview.factory;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * 控件生产者
 * 
 * @author Liqi
 * 
 */
public class WidgetFactory {
	/**
	 * 生产权重TextView控件
	 * 
	 * @param context
	 * @param weight
	 *            权重比例
	 * @return
	 */
	public static final TextView getTextView(Context context, int weight) {
		TextView textView = new TextView(context);
		LayoutParams lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, weight);
		textView.setLayoutParams(lp);
		textView.setGravity(Gravity.CENTER);
		return textView;
	}
}
