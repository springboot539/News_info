# News_info
通过聚合接口获取数据，实现新闻APP
 
注意使用的PagerSlidingTabStrip如果直接使用依赖导入

implementation 'com.astuetz:pagerslidingtabstrip:1.0.1'


将会出现属性部分对应不上，崩溃，需要将代码部分和res资源放到项目中，然后修改代码中报错的地方，才能正常使用

聚合接口每天调用次数有限制，超过次数返回Null，什么都显示不到
