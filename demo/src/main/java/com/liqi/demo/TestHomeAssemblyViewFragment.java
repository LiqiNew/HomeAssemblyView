package com.liqi.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.liqi.fragment.BaseFragment;

/**
 * 装配片段界面
 * <p>
 * MVP模式
 * <p>
 * MVPFragment有两个基类，分别是：MvpBaseTransienceFragment和MvpBaseFragment。
 * 自己看类注释。
 * </p>
 * Created by LiQi on 2017/12/8.
 */

public class TestHomeAssemblyViewFragment extends BaseFragment {
    private String mTag;
    private TextView textView;

    public TestHomeAssemblyViewFragment setTag(String tag) {
        mTag = tag;
        return this;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = $(R.id.textView);
        textView.setText(mTag + ">>>>界面");
    }

    /**如果要让BaseFragment内部去监听点击事件，那么请在控件里面设置android:clickable="true"
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String trim = textView.getText().toString().trim();
                textView.setText(trim + "\n控件点击事件触发.");
                break;
        }
    }

    @Override
    public int setLiayoutId() {
        return R.layout.test_home_assembly_view_fragment;
    }

}
