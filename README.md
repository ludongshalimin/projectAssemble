### spark集群环境，编译打包，一键部署

#### 简介：
spark编程模板，通过打成压缩包的形式  
解压运行在任意的环境里面

#### 进展情况：2019-1-12 21:30:28

1：prctl的动态库，librunner.so还有点问题，因为找不到这个库。  
目前只是将python_prctl的编译的中间库_prctl.so重命名了linrunner.so  
下一步还需要继续修改，目前已知有python_prctl，而且用python2.7编译通过  
在python2.7中可以进行import prctl操作，但是如何应用程序中呢？因为这个库  
在生产上机器上的软件是不能进行动的？？？  
  
2：对于 src/script的脚本部署程序还有待于测试，如何进行测试呢？  
需要在本地建立一个集群环境，然后写一个spark的应用程序，然后在上面进行跑
https://blog.csdn.net/linshenyuan1213/article/details/72677246  
如何将python_prctl编译成.so文件呢？？转变成这个问题

方案一：合并两个.so,prctl.so,_prctl.so合并，但是两个动态库是不能合并的  
方案二：使用libc.so.6