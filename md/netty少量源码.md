### 1.NioEventLoop继承图

![](/Users/demussong/Library/Application%20Support/marktext/images/2023-10-09-13-36-49-image.png)

+ EventLoopGroup

+ OrderedEventExecutor

+ SingleThreadEventExecutor

+ EventLoop          

+ EventExecutorGroup 管理EventExecutor,只不过在netty中EventExecutor继承了EventExecutorGroup。

+ EventExecutor 包含parent()方法返回所在的EventExecutorGroup。inEventLoop方法返回线程是否在eventLoop中执行

```java
   boolean inEventLoop();

   boolean inEventLoop(Thread thread);
```

参考：[netty系列之:EventExecutor,EventExecutorGroup和netty中的实现 - flydean - 博客园](https://www.cnblogs.com/flydean/p/15963985.html)

### Channel相关

一些方法

```java
// 会及联导致pipeline中的handler处理read
ChannelHandler.fireChannelRead(final Object msg)    
// fefwef
fwwwefew 
```
