package com.liqi.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;

import com.liqi.homeassemblyview.enums.LocationShow;
import com.liqi.homeassemblyview.factory.DataListAddFactory;
import com.liqi.homeassemblyview.interfa.OnDataListAddFactoryListener;
import com.liqi.homeassemblyview.view.HomeAssemblyLayout;
import com.liqi.homeassemblyview.view.LayoutDisposeObj;

import java.util.ArrayList;

/**
 * 装配首页界面
 * <p>
 * MVC模式.
 * 注意看注释和类注释。
 * </p>
 * Created by LiQi on 2017/12/8.
 */

public class TestHomeAssemblyViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_home_assembly_view_activity);

        HomeAssemblyLayout homeAssemblyLayout = (HomeAssemblyLayout) findViewById(R.id.main_layout);
        homeAssemblyLayout.setSuperTitleLayoutBackdrop(android.R.color.white);
        homeAssemblyLayout.setHintWire(R.color.hint_grey);
        homeAssemblyLayout.slideYesNo(true);
        homeAssemblyLayout.startLayout(addListViewItem(),4, getSupportFragmentManager(),
                LocationShow.LAYOUT_BOTTOM);
    }
    /**
     * 数据添加方案1
     * <hint>
     * 此处没有给注释，要看注释请进入调用方法里面。
     * </hint>
     */
    private OnDataListAddFactoryListener.OnDataGetListListener addListViewItem() {

        /**
         * 创建DataListAddFactory对象
         *
         */
        OnDataListAddFactoryListener addFactoryListener = DataListAddFactory.newDataListAddFactory();

        LayoutDisposeObj disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("1"))
                .setTextString("界面1");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        /**
         * 添加LayoutDisposeObj
         *
         * @param layoutDisposeObj LayoutDisposeObj对象
         */
        addFactoryListener.add(disposeObj);

        //------------------add---------------------
        disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("2"))
                .setTextString("界面2");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        /**
         * 添加LayoutDisposeObj
         *
         * @param layoutDisposeObj LayoutDisposeObj对象
         */
        addFactoryListener.add(disposeObj);

        //-----------------add----------------------
        disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("3"))
                .setTextString("界面3");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        /**
         * 添加LayoutDisposeObj
         *
         * @param layoutDisposeObj LayoutDisposeObj对象
         */
        addFactoryListener.add(disposeObj);

        //------------------add---------------------
        disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("4"))
                .setTextString("界面4");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        /**
         * 添加LayoutDisposeObj
         *
         * @param layoutDisposeObj LayoutDisposeObj对象
         */
        addFactoryListener.add(disposeObj);


        return addFactoryListener
                /**
                 * 得到获取LayoutDisposeObj集合接口
                 *
                 */
                .toGet();
    }
    /**
     * 数据添加方案2
     * <hint>
     * 此处没有给注释，要看注释请进入调用方法里面。
     * </hint>
     */
    private OnDataListAddFactoryListener.OnDataGetListListener getListViewItem() {
        ArrayList<LayoutDisposeObj> viewList = new ArrayList<>();

        LayoutDisposeObj disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("11"))
                .setTextString("界面1");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        //添加视图集合里面
        viewList.add(disposeObj);

        //------------------add---------------------
        disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("22"))
                .setTextString("界面2");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        //添加视图集合里面
        viewList.add(disposeObj);

        //-----------------add----------------------
        disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("33"))
                .setTextString("界面3");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        //添加视图集合里面
        viewList.add(disposeObj);

        //------------------add---------------------
        disposeObj = new LayoutDisposeObj();
        disposeObj.setBaseFragment(new TestHomeAssemblyViewFragment().setTag("44"))
                .setTextString("界面4");
        disposeObj.setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                R.drawable.szx_tabbar_icon_mainpage_selector, null));
        //界面适配进去容器中
        disposeObj
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                .setTextDrawablePadding(8)
                .setTextSize(14)
                .setTextPaddingTop(10)
                .setTextPaddingBottom(10);
        viewList.add(disposeObj);

        /**
         * 创建DataListAddFactory对象
         *
         */
        return DataListAddFactory.newDataListAddFactory()
                /**
                 * 添加批量LayoutDisposeObj集合对象
                 *
                 * @param objArrayList 批量LayoutDisposeObj集合对象
                 */
                .addAll(viewList)
                /**
                 * 得到获取LayoutDisposeObj集合接口
                 *
                 */
                .toGet();
    }

    /**
     * 数据添加方案3
     *
     * @return
     */
    private OnDataListAddFactoryListener.OnDataGetListListener getDataGetListListener() {
        /**
         * 创建DataListAddFactory对象
         *
         */
        return DataListAddFactory.newDataListAddFactory()
                /**
                 * 添加LayoutDisposeObj
                 * <p>
                 * LayoutDisposeObj由内部创建
                 * </p>
                 */
                .addNewLayoutDisposeObj()
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setBaseFragment(new TestHomeAssemblyViewFragment().setTag("111"))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextString("界面1")
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                        R.drawable.szx_tabbar_icon_mainpage_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextDrawablePadding(8)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextSize(14)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingTop(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingBottom(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .brushIntoList()
                //------------------------------另外一个对象添加分割线----------------
                /**
                 * 添加LayoutDisposeObj
                 * <p>
                 * LayoutDisposeObj由内部创建
                 * </p>
                 */
                .addNewLayoutDisposeObj()
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setBaseFragment(new TestHomeAssemblyViewFragment().setTag("222"))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextString("界面2")
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                        R.drawable.szx_tabbar_icon_mainpage_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextDrawablePadding(8)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextSize(14)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingTop(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingBottom(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .brushIntoList()
                //------------------------------另外一个对象添加分割线----------------
                /**
                 * 添加LayoutDisposeObj
                 * <p>
                 * LayoutDisposeObj由内部创建
                 * </p>
                 */
                .addNewLayoutDisposeObj()
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setBaseFragment(new TestHomeAssemblyViewFragment().setTag("333"))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextString("界面3")
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                        R.drawable.szx_tabbar_icon_mainpage_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextDrawablePadding(8)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextSize(14)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingTop(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingBottom(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .brushIntoList()
                //------------------------------另外一个对象添加分割线----------------
                /**
                 * 添加LayoutDisposeObj
                 * <p>
                 * LayoutDisposeObj由内部创建
                 * </p>
                 */
                .addNewLayoutDisposeObj()
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setBaseFragment(new TestHomeAssemblyViewFragment().setTag("444"))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextString("界面4")
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setDrawableSelectorId(ResourcesCompat.getDrawable(getResources(),
                        R.drawable.szx_tabbar_icon_mainpage_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextColorSelectorId(
                        // ResourcesCompat资源文件兼容对象---设置颜色选择器
                        ResourcesCompat.getColorStateList(getResources(),
                                R.color.main_tab_item_color_selector, null))
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextDrawablePadding(8)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextSize(14)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingTop(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .setTextPaddingBottom(10)
                /**
                 * 此处调用的方法是LayoutDisposeObj对象的方法，请查阅LayoutDisposeObj-API
                 */
                .brushIntoList()
                /**
                 * 得到获取LayoutDisposeObj集合接口
                 *
                 */
                .toGet();
    }
}
