![](https://cdn.jsdelivr.net/gh/SlimefunGuguProject/Networks@master/images/logo/logo_large.png)

网络是一个Slimefun附属插件，可以创建一个简单有效的物品存储与运输系统，并可以与货运系统交互。

![](https://cdn.jsdelivr.net/gh/SlimefunGuguProject/Networks@master/images/wiki/setup.png)

## 构建

你需要手动构建并使用本仓库内的`slimefun.jar`和`guizhanlibplugin.jar`

初始化本地仓库
```
mvn install:install-file -Dfile=lib/slimefun.jar -DgroupId=top.craft233 -DartifactId=Slimefun4 -Dversion=b39097e015 -Dpackaging=jar
mvn install:install-file -Dfile=lib/guizhanlibplugin.jar -DgroupId=top.craft233 -DartifactId=GuizhanLibPlugin -Dversion=1.7.6 -Dpackaging=jar

mvn clean install
```

## 下载

[![构建状态](https://builds.guizhanss.com/api/badge/SlimefunGuguProject/Networks/master/latest)](https://builds.guizhanss.com/SlimefunGuguProject/Networks/master)

## Wiki / 文档

你可以在这里查看所有物品的功能：[点击查看](https://slimefun-addons-wiki.guizhanss.cn/networks/)

## 感谢

感谢 Boomer, Cai 以及 Lucky 帮忙测试并完善插件。

感谢 **mct.tantrum.org** 的服主提供的测试环境。

另外，感谢 **mc.talosmp.net** 的 **GentlemanCheesy** 成为本人的首位赞助者！每个月能多喝一杯咖啡让我能有动力更好地编写插件。
