# AndroidGuideDemo

## 需求分析

- 横屏显示页面
- 加载网络图片，无网络图片则采用默认图片显示
- 实现点击文本链接或图片链接进行页面跳转
- 视频播放功能
- 列表网格结构呈现图文数据
- 实现星星评分控件



## 设计实现

- 横屏

- - 直接在mainActivity中调用api修改系统屏幕方向的configuration，然后再setContentView

- 加载图片

- - 对于存在图片URL的卡片，使用Glide加载网络图
  - 如果图片不存在URL，则使用默认的图片

- 跳转页面

- - 正文中采用嵌入HTML的方法实现链接文本跳转
  - 在卡片中，点击图片或者标题跳转使用了WebView，实现应用内浏览web页面

- 播放视频

- - 使用VideoView播放本地视频or在线视频（直链url）
  - 搭配MediaController实现快进，播放暂停，进度条功能

- Grid结构

- - 采用RecyclerView实现，提供一个Adapter，设计单个GridItem，指定GridLayoutManager作为布局管理器

- 星星控件

- - 使用5个ImageView填入星星图片，封装在一个LinearLayout中
  - 为每一个ImageView设置点击事件，控制显示和隐藏
  - 每次点击其中一个星星，有相应系统提示文本弹出

- 自定义带分割线标题

- - 采用自定义控件方法，封装TextView和分割线，传入标题文本和标题大小属性。

 

成果如下：

![](img\pic1.jpg)