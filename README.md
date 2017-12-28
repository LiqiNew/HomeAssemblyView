[![](https://jitpack.io/v/liqinew/homeassemblyview.svg)](https://jitpack.io/#liqinew/homeassemblyview)
[![](https://img.shields.io/badge/%E4%BD%9C%E8%80%85-%E6%9D%8E%E5%A5%87-orange.svg)](https://github.com/LiqiNew)
# HomeAssemblyView
针对viewpager+fragment封装自定义组合界面滑动控件
# 效果预览
<image src="./image/demo.gif" width="400px" height="700px"/>

### 内部远程依赖Library（已经远程依赖的Library，切勿重复依赖。）

**BaseLogger：'com.github.liqinew:baselogger:V.1.0.0'**<br>

**BaseFragment：'com.github.liqinew:basefragment:V.1.0.0'**<br>

### 如何使用

#### Gradle远程依赖 ####
**1：在项目根目录build.gradley**	<br>
```gradle
allprojects {
　　repositories {
  　　//依赖仓库
　　　maven { url 'https://jitpack.io' }
　　}
}
```
**2：依赖HomeAssemblyView**<br>
```gradle
compile 'com.github.liqinew:homeassemblyview:V.1.0.0'
```

#### 使用方式 ####
**由于HomeAssemblyLayout是一个自定义控件，既可以在XML里面定义，也可以直接通过代码new出。**
```java
HomeAssemblyLayout homeAssemblyLayout = (HomeAssemblyLayout) findViewById(R.id.xxxx);

//此处按照HomeAssemblyLayout对象API去设置对应参数
...

/**
* 布局开始装载
*
* @param getListListener 参数对象集合获取接口
*                       <p>
*                       通过DataListAddFactory对象设置数据和获取OnDataGetListListener接口
*                       </p>
* @param loadPagerCount  预先加载页面数量
*                        <p>
*                        如果设置的loadPagerCount预先加载数量大于页面list长度的话，
*                        就自动设置页面list长度为预先加载数量
*                        </p>
* @param fm              碎片管理者
* @param location        标题显示位置：LocationShow.LAYOUT_TOP=顶部显示,LAYOUT_BOTTOM=底部显示
* @return HomeAssemblyLayout
*/
homeAssemblyLayout.startLayout(getListListener,loadPagerCount, fm,location);
```
##### 如何通过DataListAddFactory添加LayoutDisposeObj对象
**方式一**
```java
/**
* 数据添加方案1。（添加了两条数据）
*/
private OnDataListAddFactoryListener.OnDataGetListListener addListViewItem() {

               /**
                * 创建DataListAddFactory对象
                *
                */
               OnDataListAddFactoryListener addFactoryListener = DataListAddFactory.newDataListAddFactory();

                /**
                * 创建LayoutDisposeObj对象
                */
               LayoutDisposeObj disposeObj = new LayoutDisposeObj();
               //按照LayoutDisposeObj对象API去设置
                ....
               /**
                * 添加LayoutDisposeObj
                */
               addFactoryListener.add(disposeObj);

               //------------------add---------------------
               /**
               * 创建LayoutDisposeObj对象
               */
               disposeObj = new LayoutDisposeObj();
               //按照LayoutDisposeObj对象API去设置
                ....
               /**
                * 添加LayoutDisposeObj
                */
               addFactoryListener.add(disposeObj);

               return addFactoryListener
                       /**
                        * 得到获取LayoutDisposeObj集合接口
                        *
                        */
                       .toGet();
           }
```
**方式二**
```java
/**
* 数据添加方案2。（添加了两条数据）
*/
private OnDataListAddFactoryListener.OnDataGetListListener getListViewItem() {
        ArrayList<LayoutDisposeObj> viewList = new ArrayList<>();
        /**
        * 创建LayoutDisposeObj对象
        */
        LayoutDisposeObj disposeObj = new LayoutDisposeObj();
        //按照LayoutDisposeObj对象API去设置
         ....
        //添加视图集合里面
        viewList.add(disposeObj);

        //------------------add---------------------
        /**
        * 创建LayoutDisposeObj对象
        */
        disposeObj = new LayoutDisposeObj();
        //按照LayoutDisposeObj对象API去设置
         ....
        //添加视图集合里面
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
```
**方式三**
```java
/**
* 数据添加方案3。（添加了两条数据）
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
                .setBaseFragment(new TestHomeAssemblyViewFragment())
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
                .setBaseFragment(new TestHomeAssemblyViewFragment())
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
                /**
                * 得到获取LayoutDisposeObj集合接口
                *
                */
                .toGet();
    }
```
#### A P I ####
##### HomeAssemblyLayout自定义组合布局操作API
```java
/**
* 设置页面是否可以滑动
*
* @param why true是可以滑动，false是不能滑动。默认是true。
* @return HomeAssemblyLayout
*/
HomeAssemblyLayout.slideYesNo(boolean why);

/**
* 设置标题父布局Padding
*
* @param left 左Padding
* @param top 上Padding
* @param right 右Padding
* @param bottom 下Padding
* @return HomeAssemblyLayout
*/
HomeAssemblyLayout.setSuperTitleLayoutPadding(int left, int top,int right, int bottom);

/**
* 设置标题父布局背景Drawable
*
* @param background Drawable类型
* @return HomeAssemblyLayout
*/
HomeAssemblyLayout.setSuperTitleLayoutBackdrop(Drawable background);

/**
* 设置线条的颜色值
*
* @param color 线条的颜色值
* @return HomeAssemblyLayout
*/
HomeAssemblyLayout.setHintWire(@ColorRes int color);

/**
* 设置标题父布局背景颜色
*
* @param resid 颜色资源ID
* @return HomeAssemblyLayout
*/
HomeAssemblyLayout.setSuperTitleLayoutBackdrop(@ColorRes int resid);

/**
* 布局开始装载
*
* @param getListListener 参数对象集合获取接口
*                       <p>
*                       通过DataListAddFactory对象设置数据和获取OnDataGetListListener接口
*                       </p>
* @param loadPagerCount  预先加载页面数量
*                        <p>
*                        如果设置的loadPagerCount预先加载数量大于页面list长度的话，
*                        就自动设置页面list长度为预先加载数量
*                        </p>
* @param fm              碎片管理者
* @param location        标题显示位置：LocationShow.LAYOUT_TOP=顶部显示,LAYOUT_BOTTOM=底部显示
* @return HomeAssemblyLayout
*/
HomeAssemblyLayout.startLayout(
            OnDataListAddFactoryListener.OnDataGetListListener getListListener,
            int loadPagerCount,
            FragmentManager fm,
            LocationShow location);
```

##### DataListAddFactory集合数据添加工厂对象介绍
DataListAddFactory 实现 “如下三个对外操作接口”<br>
* OnDataListAddFactoryListener --> 集合数据添加工厂对外操作暴露接口
* OnDataListAddFactoryListener.OnDataGetListListener -->获取存储LayoutDisposeObj的List集合接口，Library内部调用。
* OnDataFactoryBrushIntoListener -->第三方对象刷进添加工厂集合数据接口，Library内部调用。<br><br>

**DataListAddFactory操作API**
```java
/**
* 创建DataListAddFactory对象，并返回对外操作接口OnDataListAddFactoryListener
*
* @return OnDataListAddFactoryListener
*/
DataListAddFactory.newDataListAddFactory();
```
**OnDataListAddFactoryListener接口操作API**
```java
/**
* 添加LayoutDisposeObj
* <p>
* LayoutDisposeObj由内部创建
* </p>
*
* @return LayoutDisposeObj
*/
OnDataListAddFactoryListener.addNewLayoutDisposeObj();

/**
* 添加LayoutDisposeObj
*
* @param layoutDisposeObj LayoutDisposeObj对象
* @return OnDataListAddFactoryListener
*/
OnDataListAddFactoryListener.add(LayoutDisposeObj layoutDisposeObj);

/**
* 添加批量LayoutDisposeObj集合对象
*
* @param objArrayList 批量LayoutDisposeObj集合对象
* @return OnDataListAddFactoryListener
*/
OnDataListAddFactoryListener.addAll(ArrayList<LayoutDisposeObj> objArrayList);

/**
* 得到获取LayoutDisposeObj集合接口，并返回获取存储LayoutDisposeObj的List集合接口OnDataGetListListener
*
* @return OnDataGetListListener
*/
OnDataListAddFactoryListener.toGet();
```

**OnDataListAddFactoryListener.OnDataGetListListener接口操作API**
```java
/**
* 获取LayoutDisposeObj集合
*
* @return LayoutDisposeObj集合.ArrayList<LayoutDisposeObj>
*/
OnDataGetListListener.getListLayout();
```

**OnDataFactoryBrushIntoListener接口操作API**
```java
/**
* 第三方对象刷进方法，并返回OnDataListAddFactoryListener->集合数据添加工厂对外操作暴露接口
*
* @return OnDataListAddFactoryListener
*/
OnDataFactoryBrushIntoListener.brushIntoList();
```

##### LayoutDisposeObj单个布局内部数据存取对象
**LayoutDisposeObj构造函数**

```java
/**
* 无参构造函数
*/
public LayoutDisposeObj() {
...
}

/**
* 有参构造函数
* @param onDataFactoryBrushIntoListener  第三方对象刷进添加工厂集合数据接口
*/
public LayoutDisposeObj(OnDataFactoryBrushIntoListener onDataFactoryBrushIntoListener) {
...
}
```

**LayoutDisposeObj操作API**
```java
/**
* 把当前对象刷进DataListAddFactory集合数据添加工厂集合中。
* <p>
*     调用此方法必须要把OnDataFactoryBrushIntoListener传输进来
* </p>
* @return OnDataListAddFactoryListener
*/
LayoutDisposeObj.brushIntoList();

/**获取当前界面title控件文本内容
*
* @return title控件文本内容
*/
LayoutDisposeObj.getTextString();

/**赋值当前界面title控件文本内容
*
* @param textString title控件文本内容
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextString(String textString);

/**
* 获取展示的Fragment
* @return 展示的Fragment
*/
LayoutDisposeObj.getBaseFragment();

/**设置展示的Fragment
*
* @param baseFragment 展示的Fragment
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setBaseFragment(BaseFragment baseFragment);

/**
*  获取当前界面title控件文本字体颜色选择器
*  <p>
*      必须得在选择器里面用Enabled标签实现
*  </p>
* @return 文本字体颜色选择器
*/
LayoutDisposeObj.getTextColorSelectorId();

/**
*  设置当前界面title控件文本字体颜色选择器
*  <p>
*      选择器必须得在选择器里面用Enabled标签实现
*  </p>
* @param textColorSelectorId 文本字体颜色选择器
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextColorSelectorId(ColorStateList textColorSelectorId);

/**获取当前界面title控件图片选择器
*
* @return 控件图片选择器
*/
LayoutDisposeObj.getDrawableSelectorId();

/**
*  设置当前界面title控件图片选择器
*  <p>
*      选择器必须得在选择器里面用Enabled标签实现
*  </p>
* @param drawableSelectorId 控件图片选择器
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setDrawableSelectorId(Drawable drawableSelectorId);

/**获取当前界面title控件文本字体大小
*
* @return 文本字体大小
*/
LayoutDisposeObj.getTextSize();

/**
* 设置当前界面title控件文本字体大小
* @param textSize 文本字体大小（默认15）
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextSize(int textSize);

/**
* 获取当前界面title控件图片跟字体的间距
* @return 图片跟字体的间距
*/
LayoutDisposeObj.getTextDrawablePadding();

/**
* 设置当前界面title控件图片跟字体的间距
* <p>
*     上下间距
* </p>
* @param textDrawablePadding 图片跟字体的间距
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextDrawablePadding(int textDrawablePadding);

/** 获取当前界面title控件左边偏距间距
*
* @return 左边偏距间距
*/
LayoutDisposeObj.getTextPaddingLeft();

/**
* 设置当前界面title控件左边偏距间距
* @param textPaddingLeft 左边偏距间距
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextPaddingLeft(int textPaddingLeft);

/**
* 获取当前界面title控件顶部偏距间距
* @return 顶部偏距间距
*/
LayoutDisposeObj.getTextPaddingTop();

/**
* 设置当前界面title控件顶部偏距间距
* @param textPaddingTop 顶部偏距间距
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextPaddingTop(int textPaddingTop);

/**
* 获取当前界面title控件右边偏距间距
* @return 右边偏距间距
*/
LayoutDisposeObj.getTextPaddingRight();

/**
* 设置当前界面title控件右边偏距间距
* @param textPaddingRight 右边偏距间距
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextPaddingRight(int textPaddingRight);

/**获取当前界面title控件底部偏距间距
*
* @return 底部偏距间距
*/
LayoutDisposeObj.getTextPaddingBottom();

/**
* 设置当前界面title控件底部偏距间距
* @param textPaddingBottom 底部偏距间距
* @return LayoutDisposeObj
*/
LayoutDisposeObj.setTextPaddingBottom(int textPaddingBottom);
```
