package com.liqi.homeassemblyview.interfa;

import com.liqi.homeassemblyview.view.LayoutDisposeObj;

import java.util.ArrayList;

/**
 * 集合数据添加工厂对外操作暴露接口
 * Created by LiQi on 2017/12/27.
 */

public interface OnDataListAddFactoryListener {
    /**
     * 添加LayoutDisposeObj
     * <p>
     * LayoutDisposeObj由内部创建
     * </p>
     *
     * @return LayoutDisposeObj
     */
    LayoutDisposeObj addNewLayoutDisposeObj();

    /**
     * 添加LayoutDisposeObj
     *
     * @param layoutDisposeObj LayoutDisposeObj对象
     * @return DataListAddFactory
     */
    OnDataListAddFactoryListener add(LayoutDisposeObj layoutDisposeObj);

    /**
     * 添加批量LayoutDisposeObj集合对象
     *
     * @param objArrayList 批量LayoutDisposeObj集合对象
     * @return DataListAddFactory
     */
    OnDataListAddFactoryListener addAll(ArrayList<LayoutDisposeObj> objArrayList);

    /**
     * 得到获取LayoutDisposeObj集合接口
     *
     * @return OnDataGetListListener
     */
    OnDataGetListListener toGet();

    /**
     * 获取LayoutDisposeObj集合接口
     */
    interface OnDataGetListListener {
        /**
         * 获取LayoutDisposeObj集合
         *
         * @return LayoutDisposeObj集合
         */
        ArrayList<LayoutDisposeObj> getListLayout();
    }
}
