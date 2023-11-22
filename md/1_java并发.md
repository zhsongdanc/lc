### problems list
1. ForkJoinPool原理和实现？
2. synchronized和reentrantLock区别?并发量少的时候哪个性能更高？
3. synchronized并发量很高的情况下会有什么问题呢？如何解决？
4. 通过什么命令可以设置禁止偏向锁？(-XX:-UseBiasedLocking)
5. 为什么volatile修饰的变量都在类里，而不去修饰局部变量呢？
6. synchronized锁状态升级过程、CAS原理
7. ReentrantLock和AQS源码，state状态变量与 CountDownLatch 的联系等
8. volatile关键字原理？为什么volatile修饰的变量都在类里，而不去修饰局部变量呢？
9. 有3个操作 a b c，希望a和b执行完后 c再执行（Object类下的wait() & notify()，CountDownLatch，ReentrantLock的await() & signal()）
10. 使用线程池，设置线程数的依据是什么
11. synchronized为什么设计为可重入锁
12. HashMap怎么处理哈希冲突的
13. 分段锁是可重入的吗
14. 你怎么理解可重入锁
15. 非公平锁吞吐量为什么比公平锁大
16. JVM为什么把堆区进一步的划分
17. 关闭线程池shutdown和shutdownnow区别
18. 9、线程池参数，默认用的是什么阻塞队列【linkedblockingQueue】，FixedThreadPool这种使用的是什么阻塞队列
19. final
20. wait sleep区别
21. 







### reference answer
3.synchronized是Java中的一个关键字，用于控制并发访问共享资源，保证线程安全。然而，在并发量很高的情况下，使用synchronized可能会导致以下问题：

性能下降：当一个线程访问一个synchronized同步块或方法时，其他所有试图访问这个同步块或方法的线程都会被阻塞，直到第一个线程释放锁。这会导致大量的线程阻塞，从而降低系统的整体性能。

死锁：如果两个或更多的线程在互相等待对方释放锁，就可能会发生死锁。这种情况下，涉及的所有线程都无法继续执行。

饥饿：由于Java的内置锁是不公平的，因此在高并发的情况下，有可能出现某些线程长时间获取不到锁的情况，也就是所谓的"饥饿"现象。

解决这些问题的方法有很多，以下是一些常见的策略：

减少锁的粒度：尽量只在必要的地方使用synchronized，并尽可能缩小同步块的范围。这样可以减少线程阻塞的可能性，提高系统的并发性能。

使用并发工具类：Java的java.util.concurrent包提供了许多并发工具类，如ReentrantLock、Semaphore、CountDownLatch等。这些工具类提供了比synchronized更灵活的并发控制机制。

避免死锁：避免死锁的一个常见策略是按照一定的顺序获取锁，这样可以防止循环等待的发生。

使用线程池：通过使用线程池，可以控制并发线程的数量，避免过多的线程竞争资源，从而提高系统的性能。

使用分布式锁：如果是在分布式系统中，可以考虑使用分布式锁，如Zookeeper、Redis等提供的分布式锁。

