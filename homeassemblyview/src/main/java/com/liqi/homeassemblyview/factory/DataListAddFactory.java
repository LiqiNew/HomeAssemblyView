package com.liqi.homeassemblyview.factory;

import com.liqi.homeassemblyview.interfa.OnDataFactoryBrushIntoListener;
import com.liqi.homeassemblyview.interfa.OnDataListAddFactoryListener;
import com.liqi.homeassemblyview.view.LayoutDisposeObj;

import java.util.ArrayList;

/**
 * 集合数据添加工厂
 * Created by LiQi on 2017/12/27.
 */

public class DataListAddFactory implements OnDataFactoryBrushIntoListener, OnDataListAddFactoryListener,OnDataListAddFactoryListener.OnDataGetListListener {
    private ArrayList<LayoutDisposeObj> mListLayout;
    private LayoutDisposeObj mLayoutDisposeObj;

    private DataListAddFactory() {
        mListLayout = new ArrayList<>();
    }

    /**
     * 创建DataListAddFactory对象
     *
     * @return DataListAddFactory
     */
    public static OnDataListAddFactoryListener newDataListAddFactory() {
        return new DataListAddFactory();
    }

    /**
     * 添加LayoutDisposeObj
     * <p>
     * LayoutDisposeObj由内部创建
     * </p>
     *
     * @return LayoutDisposeObj
     */
    @Override
    public LayoutDisposeObj addNewLayoutDisposeObj() {
        mLayoutDisposeObj = new LayoutDisposeObj(this);
        return mLayoutDisposeObj;
    }

    /**
     * 添加LayoutDisposeObj
     *
     * @param layoutDisposeObj LayoutDisposeObj对象
     * @return DataListAddFactory
     */
    @Override
    public OnDataListAddFactoryListener add(LayoutDisposeObj layoutDisposeObj) {
        mListLayout.add(layoutDisposeObj);
        return this;
    }

    /**
     * 添加批量LayoutDisposeObj集合对象
     *
     * @param objArrayList 批量LayoutDisposeObj集合对象
     * @return DataListAddFactory
     */
    @Override
    public OnDataListAddFactoryListener addAll(ArrayList<LayoutDisposeObj> objArrayList) {
        mListLayout.addAll(objArrayList);
        return this;
    }

    @Override
    public OnDataGetListListener toGet() {
        return this;
    }

    /**
     * 获取LayoutDisposeObj集合
     *
     * @return LayoutDisposeObj集合
     */
    @Override
    public ArrayList<LayoutDisposeObj> getListLayout() {
        return mListLayout;
    }

    @Override
    public OnDataListAddFactoryListener brushIntoList() {
        if (null != mLayoutDisposeObj) {
            add(mLayoutDisposeObj);
            mLayoutDisposeObj = null;
        }
        return this;
    }
}
