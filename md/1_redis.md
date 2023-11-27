### problems list （注意结合场景）
1. Redis Cell，令牌桶算法以及介绍其他几个流量控制算法
2. 项目里Redis分布式锁的实现，Lua脚本了解吗，锁误删和超时问题，Reddison
3. 缓存击穿问题？
4. 5、Redis底层数据结构讲一讲
5. 如何保持和数据库的一致性呢？
6. 如果使用Redis实现类似淘宝的历史访问记录？
7. 跳表是如何实现的？你是通过什么地方了解跳表的,跳表的缺点是什么？
8. redis key过期策略有哪些？
9. redis如何实现分布式锁
10. redis缓存双写不一致，如何解决
11. redis缓存雪崩
12. redis持久化方式
13. redis如何保证数据一致性，高并发的情况下如何保证？
14. 比如你缓存前5个商品的信息，你怎么判断他们是前5个商品（UV）
    使用HyperLogLog统计UV，你在项目中是怎么实现增加操作的
15. pipeline
16. 缓存穿透、击穿、雪崩
17. hyperloglog
18. Caffeine的实现原理
    Guava的LoadingCache和ReloadableCache（没了解过）
19. Redis为什么这么快
20. 如果Redis数据超过内存限制，该如何处理
21. Redis缓存过期如何实现的？底层呢？
22. redis缓存淘汰策略
23. 13，Redis一个DB的结构（√）

24. 14，Redis的网络模型，聊聊Reactor执行流程，哪些地方用的多线程。（√）

25. 15，哨兵集群如何监控，故障转移，通知（√）
26. 16，主从模式，全量同步流程，增量同步流程，无磁盘复制优化（√）
27. Redis数据结构和底层实现
28. Redis做什么用，数据库缓存一致性，高并发下直接删缓存会不会出问题
29. 一致性哈希
30. zset用跳表？















### reference answer
2.https://juejin.cn/post/7011503283768393736#heading-9
4.string,list,set,zset,hash,geo,hyperloglog
6.要使用 Redis 实现类似淘宝的历史访问记录功能，可以使用 Redis 的列表（List）数据结构。以下是一个简单的实现方法：

为每个用户创建一个列表：当用户访问一个商品时，将该商品的 ID 添加到用户的访问记录列表中。可以使用用户的 ID 作为 Redis 键，例如 user_history:user_id。

添加访问记录：当用户访问一个商品时，使用 LPUSH 命令将商品 ID 添加到用户的访问记录列表的开头。例如：

复制
LPUSH user_history:user_id product_id
去重：为了避免重复的访问记录，可以在添加访问记录之前，先使用 LREM 命令将列表中已存在的相同商品 ID 删除。例如：

复制
LREM user_history:user_id 0 product_id
限制列表长度：为了限制访问记录的数量，可以使用 LTRIM 命令来保留列表中的前 N 个元素。例如，如果要保留最近的 10 个访问记录，可以执行：

复制
LTRIM user_history:user_id 0 9
获取访问记录：要获取用户的访问记录，可以使用 LRANGE 命令。例如，要获取用户最近的 10 个访问记录，可以执行：

复制
LRANGE user_history:user_id 0 9
15.lua可以保证多条命令的原子性，但中间执行失败，无法回滚，不支持cluster模式（不在一个hash slot）
pipeline将多个操作打包为一个进行网络传输，客户端和服务端共同实现，
19.内存；reactor;单线程没有上下文切换
20.优化数据结构；设置过期时间；使用lru;集群；内存优化（压缩，缓冲区）；硬件
30.They are not very memory intensive. It's up to you basically. Changing parameters about the probability of a node to have a given number of levels will make then less memory intensive than btrees.
A sorted set is often target of many ZRANGE or ZREVRANGE operations, that is, traversing the skip list as a linked list. With this operation the cache locality of skip lists is at least as good as with other kind of balanced trees.
They are simpler to implement, debug, and so forth. For instance thanks to the skip list simplicity I received a patch (already in Redis master) with augmented skip lists implementing ZRANK in O(log(N)). It required little changes to the code.
