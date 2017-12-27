package com.liqi.homeassemblyview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;

import com.liqi.Logger;
import com.liqi.homeassemblyview.view.LayoutDisposeObj;

import java.util.ArrayList;

/**
 * Viewpager适配器(实现了数据刷新功能)
 *
 * @author Liqi
 */
public class ViewPagerAdapter<T extends LayoutDisposeObj> extends FragmentPagerAdapter {
    private ArrayList<T> mFragmentList;
    private FragmentManager mFm;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<T> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mFm = fm;
    }

    @Override
    public Fragment getItem(int index) {
        return mFragmentList.get(index).getBaseFragment();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mFragmentList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub
        return view == ((Fragment) object).getView();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // // TODO Auto-generated method stub
        // super.destroyItem(container, position, object);
    }

    /**
     * 给外部调用刷新方法（因为是用fragment做的，所以刷新数据时，
     * 一定要把缓存在FragmentTransaction里面的fragment的数据清楚掉）
     *
     * @param fragments
     */
    public void notifyDataRefresh(ArrayList<T> fragments) {
        if (null != mFragmentList) {
            FragmentTransaction ft = mFm.beginTransaction();
            for (LayoutDisposeObj layoutObj : mFragmentList) {
                ft.remove(layoutObj.getBaseFragment());
            }
            ft.commit();
            mFm.executePendingTransactions();
            if (!mFragmentList.isEmpty()) {
                mFragmentList.clear();
            }
            mFragmentList.addAll(fragments);
        } else {
            mFragmentList = fragments;
        }
        Logger.i("HomeAssemblyView", "ViewPagerAdapter-->List的长度：" + mFragmentList.size());
        notifyDataSetChanged();
    }
}
