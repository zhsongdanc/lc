### problems list
1. threadlocal基本实现方式
2. 泛型的上下界如何界定，什么时候用什么？
3. 讲—下CopyOnWriteArrayList了解多少
4. 内存泄露的场景哪些呢？
5. 线程有几种创建方法？
6. 线程池的创建方法了解哪些？
7. 7、各种排序算法的时间复杂度和空间复杂度，详细讲讲堆排序和快排实现？
8. Hashmap底层原理？为什么长度为8就转换为红黑树？因子为什么默认0.75？底层算法是什么？
9. 接口 抽象类 区别 使用场景？ 
10. LinkedHashMap底层实现？用在什么场景？
11. 讲一下TreeMap？为什么要自定义排序？
12. TreeMap底层是如何保证元素不重复的？
13. Arraylist和Linkedlist区别，底层实现？Arraylist是如何扩容的？
14. ThreadLocal使用场景
    使用时有什么需要注意的（内存泄漏）
15. 往Map存放自定义的类型，有什么需要注意的
16. ConcurrentHashMap怎么保证线程安全的
    已经用了synchronized，为什么还要用CAS呢
    扩容是怎么保证线程安全的
    如果一个ConcurrentHashMap在被多个线程操作，在进行扩容操作时会有几个线程在处理
    （这块看过源码，所有细节全答上来了）
17. java多线程场景我们选用什么List
18. JDK动态代理，不实现接口就不能做代理了吗，为什么
19. Java为什么不可以多继承
20. 4. Java语言的泛型是怎么实现的？为了解决什么问题而出现的？泛型的效率一定很低吗？
21. 1. HashMap jdk1.7/8有什么区别？元素数量下降长会变回链表吗？
22. 2. HashMap在多线程场景下使用，jdk7/8有都什么问题？问题有什么区别？
23. 3. ConcurrentHashMap怎么保证线程安全的？1.7的分段锁怎么实现的？
24. 读写锁 及其扩展
25. Trie树时间复杂度，实现原理，Trie树比HashMap的优势【不会】
26. 7、String类型为什么用final修饰了【不会】
27. 12、了解红黑树吗【不了解】
28. 17、如何比较一个类中两个对象，Comparable和Comparator接口
29. 对象头
30. Java会不会出现内存泄漏
31. CopyOnWriteList和ConcurrentHashMap原理















### reference answer
8.为了提高查询效率，长度为8，是根据经验值，此时链表和红黑树差不多。节点小于6会转为链表。
0.75是为了平衡时间和空间，负载因子过高，HashMap中的冲突可能会增加。如果负载因子过低，HashMap的空间利用率就会降低
算法的目的是为了减少哈希冲突，提高哈希码的随机性和均匀性，防止高位和低位分布不均，可能会导致哈希冲突。
9.接口（定义规范，） 抽象类（封装通用行为）
18. CopyOnWriteArrayList：CopyOnWriteArrayList是一个线程安全的List实现，适用于读多写少的场景。它通过在写操作时创建一个新的副本来实现线程安全，因此读操作不会被阻塞。适用于需要高效读取的场景，但写操作的性能较低。

Vector：Vector是一个传统的线程安全的List实现，它使用了同步方法来保证线程安全。适用于需要线程安全且对性能要求不高的场景。

Collections.synchronizedList：可以使用Collections.synchronizedList方法将普通的List转换为线程安全的List。它使用了同步块来保证线程安全。适用于对性能要求不高的场景。
19.方法名、字段名冲突
20. 
27.几个特点：(1)root=黑(2)红色节点的子节点是黑色(3)从根到叶子黑色节点个数相同(4)叶子=黑(5)黑or红

30.内存泄露：不再使用的对象持续占有内存空间，没有被释放
### todo
threadlocal基本实现，使用场景，注意内存泄露(ref:https://blog.csdn.net/qianshangding0708/article/details/117203133)
copyonwrite和读写锁对比
map解读：https://juejin.cn/post/6844903813892014087,https://juejin.cn/post/6844903796225605640
