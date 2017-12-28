package com.liqi.homeassemblyview.interfa;

/**
 * 第三方对象刷进添加工厂集合数据接口
 * Created by LiQi on 2017/12/27.
 */

public interface OnDataFactoryBrushIntoListener {
    /**
     * 第三方对象刷进方法，并返回OnDataListAddFactoryListener->集合数据添加工厂对外操作暴露接口
     *
     * @return OnDataListAddFactoryListener
     */
    OnDataListAddFactoryListener brushIntoList();
}
