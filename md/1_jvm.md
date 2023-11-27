### problems list
1. asm
2. 字节码相关
3. cms
   说一下 JVM 的主要组成部分？及其作用？
4. JVM的回收算法有哪些，优缺点各是什么？新生代和老年代可以只用一个算法吗？
5. 讲—下JVM的内存区域？Java虚拟机栈内部都有什么东西？问的是栈帧内部
6. new一个对象时申请内存的流程是怎么样的？
7. 可达性分析法的GC Root是如何确定的？有哪几种
8. 虚引用有什么作用呢？实际生产有没有使用过
9. 新生代和老年代的比例知道吗？
10. 新生代和老年代分别有哪些收集器？
11. 你们公司用的是哪个收集器？G1有用过吗？
12. 如果CMS的并发标记阶段运行失败呢？
13. ZGC了解吗？
14. g1收集器 收集过程
15. jvm如何调优？jvm常用参数有哪些？
16. 有一个服务，频繁的 Full GC，可能是什么原因导致的
一般怎么排查
说一下JVM的常用命令
17. Java变量在内存各个区域的分布,把局部变量放到堆里会有什么问题,把对象动态分配到栈中会有什么问题
    其实上面的问题考察的本质就是：Java堆和栈的区别 优缺点，但这些问题我没有仔细想过，栽了。
18. g1一定比cms快吗（答得不好）
19. full gc,yonggc
20. 方法栈：局部变量表，操作数栈，动态链接都细致聊了一下，程序计数器：为什么要有这个？
21. 10，聊G1 ， CardTable和RememberSet怎么配合解决跨代引用？什么时候更新RememberSet？（√）
22. 7，对象逃逸分析 ，常量替换优化（√）
23. 16、为什么jdk8将方法区放到了本地内存
24. jvm常用参数
25. 对象头
26. JVM为什么把堆区进一步的划分
27. 4. Full GC会在哪些场景发生？
28. 堆外内存怎么回收的
29. 三个垃圾回收指标（吞吐量、停顿时间、回收频率）
30. 常用的一些gc参数
31. new一个对象的过程




什么是双亲委派模型？

说一下类装载的执行过程？

说一下 JVM 有哪些垃圾回收器？

详细介绍一下 CMS 垃圾回收器？



说一下 JVM 调优的工具？

常用的 JVM 调优的参数都有哪些？

怎么获取 Java 程序使用的内存？堆使用的百分比？


常用的工具
### reference answer
refer link: https://www.cnblogs.com/chiangchou/p/jvm-2.html#_label2_6
https://juejin.cn/post/6844904106268557320
https://blog.csdn.net/lhy18235303007/article/details/115774839



3.缺点：浮动垃圾，预留空间不足触发并发失败使用serial old进行回收，内存碎片
14.(1)可预测的停顿时间（2）内存布局（3）大对象Region(4)g1回收过程（5）g1新生代回收（6）混合回收
24.-Xms(JVM的初始堆内存大小。例如，-Xms512m表示将初始堆内存设置为512MB。),-Xmx(JVM的最大堆内存大小)
-Xss设置每个线程的栈大小。默认值因平台而异。例如，-Xss256k表示将每个线程的栈大小设置为256KB。
-XX:+UseParallelGC:启用并行垃圾回收器。并行垃圾回收器可以提高垃圾回收的效率。
-XX:+UseConcMarkSweepGC：启用并发标记清除垃圾回收器。并发标记清除垃圾回收器可以减少垃圾回收的停顿时间。
-XX:+UseG1GC：启用G1（Garbage-First）垃圾回收器。G1垃圾回收器是JDK 7及之后引入的一种全新的垃圾回收器，可以在更短的停顿时间内实现更高的吞吐量。
-XX:ParallelGCThreads：设置并行垃圾回收器的线程数。例如，-XX:ParallelGCThreads=4表示将并行垃圾回收器的线程数设置为4。
25.markword(32bit/64bit),指针（指向对应的Class对象），数组长度

27.永久代空间不足（full gc顺代回收永久代），System.gc可能，老年代空间不足存储大对象，cms导致
30.cms常用参数：
-XX:+UseConcMarkSweepGC
-XX:CMSInitiatingOccupancyFraction=92，老年代使用比例达到后触发full gc
-XX:+UseCMSInitiatingOccupancyOnly 只使用设定代阈值（CMSInitiatingOccupancyFraction）
不建议配置上面这个参数，如果不配置，jvm只有第一次使用CMSInitiatingOccupancyFraction，后续使用经验值
-XX:CMSBootstrapOccupancy=92
-xx:CMSWaitDuration=2000
-XX:+UseCMSCompactAtFullCollection（默认开启，在回收时整理，导致stw）
-XX:CMSFullGCsBeforeCompaction CMS在执行过若干次不整理空间的 Full GC 之后，下一次进入 Full GC 前会先进行碎片整理（默认值为0，表示每次进入 Full GC 时都进行碎片整理

g1常用参数：（https://www.cnblogs.com/chiangchou/p/jvm-2.html#_label2_6）
-XX: MaxGCPauseMillis  指定停顿时间，默认200ms，太低可能导致回收速度赶不上分配速度，导致堆满降低性能
-XX:G1HeapRegionSize 默认堆大小/2048，每个region大小
-XX:G1NewSizePercent，-XX:G1MaxNewSizePercent新生代默认占堆内存的5%，但最多不超过60%，超过之后将edon区复制到survivor区，实际根据停顿时间选取价值最大的
-XX:InitiatingHeapOccupancyPercent 默认45%，达到会触发一次年轻代+老年代的混合回收
-XX:G1MixedGCCountTarget 默认8次，一次gc中几次混合回收
-XX:G1HeapWastePercent，默认值是 5%。就是在混合回收时，Region回收后，就会不断的有新的Region空出来，一旦空闲出来的Region数量超过堆内存的5%，就会立即停止混合回收，即本次混合回收就结束了。
-XX:G1MixedGCLiveThresholdPercent，默认值是85%。意思是回收Region的时候，必须存活对象低于Region大小的85%时才可以进行回收，一个Region存活对象超过85%，就不必回收它了，因为要复制大部分存活对象到别的Region，这个成本是比较高的

双亲委派：https://blog.csdn.net/justloveyou_/article/details/72231425?spm=1001.2101.3001.6650.9&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-9-72231425-blog-52631940.235%5Ev38%5Epc_relevant_sort_base1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-9-72231425-blog-52631940.235%5Ev38%5Epc_relevant_sort_base1&utm_relevant_index=10
