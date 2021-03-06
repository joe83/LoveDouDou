# LoveDouDou
爱逗逗——集新闻资讯，影视评论，漂亮妹子，视频播放于一身的app，用于练习MVP+Retrofit+RxJava+Glide框架，如今将其开源，仅供学习探讨，禁止商用。
以下为应用app各模块截图：

![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/1.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/2.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/3.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/4.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/5.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/6.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/7.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/8.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/9.png)![](https://github.com/wangfeng19930909/LoveDouDou/blob/master/screentshot/10.png)

*****功能模块：

新闻：采用聚合数据的头条 api,可增加频道订阅管理
妹子：美女壁纸
视频：包括花絮，预告，集锦，时尚四个分类
我的：增加一点背景view动画特效，提供分享，笑话模块功能

*****项目亮点：

通过config.grade进行各引用库版本管理
mvp模式：简单的mvp一目了然,解耦model和view层，契约类管理mvp，一目了然，实现纵向解耦，基类完美封装，避免频繁new对象
RxJava:包括Rx处理服务器请求、缓存、线程调度的完美封装
复杂列表处理，使用type进行区分，在BaseREcycleviewAdapter中体现
组件化开发，横向解耦
封装各种工具类，比如压缩图片、轮播器、查看大图、缓存工具、图片选择器，以common的module形式依赖
自定义分享布局，更接近需求定制
各种封装好的依赖库，比如Irecyclerview：包含万能适配器、recyclerview的下拉刷新上拉加载更多、自定义刷新头和加载更多头；selectordialog：经常使用到的几种Dialog；oneKeyShareSDK：社交分享；微信和支付宝封装等等
无关业务内容封装成model，基于此框架可以快速开发一个app

*****用到的开源库有：

org.jsoup:jsoup:1.10.2'//网页解析器

com.flaviofaria:kenburnsview:1.0.7'//浮动view

com.github.florent37:diagonallayout:1.0.2'

com.balysv.materialmenu:material-menu:2.0.0'

org.jetbrains:annotations:15.0'

me.shaohui:bottomdialog:1.1.9'

om.flyco.tablayout:FlycoTabLayout_Lib:2.0.8@aar

com.github.clans:fab:1.6.4

com.squareup.retrofit2:retrofit:2.0.0-beta3

io.reactivex:rxjava:1.0.1

io.reactivex:rxandroid:1.0.1

com.github.bumptech.glide:glide:3.6.1

fm.jiecao:jiecaovideoplayer:4.7.0


本人会坚持在这个项目上实践最新的技术，也会争取拓展更多的阅读内容，欢迎各位关注！ 注意：本项目还在测试阶段，发现 bug 或有好的建议欢迎issue、email(wangfengkxhp@foxmail.com),如果感觉对你有帮助也欢迎点个 star、fork，本项目仅做学习交流使用，请勿用于其他用途,如若发现资源存在侵权，请第一时间联系删除。

MIT License
=================================== 
Copyright 2017-2018, wangfeng19930909

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
