### problems list
1. threadlocal基本实现方式
2. 泛型的上下界如何界定，什么时候用什么？
3. 讲—下CopyOnWriteArrayList了解多少
4. Full GC会在哪些场景发生？
5. 内存泄露的场景哪些呢？
6. 线程有几种创建方法？
7. 线程池的创建方法了解哪些？
8. 7、各种排序算法的时间复杂度和空间复杂度，详细讲讲堆排序和快排实现？
9. Hashmap底层原理？为什么长度为8就转换为红黑树？因子为什么默认0.75？底层算法是什么？
10. 接口 抽象类 区别 使用场景？
11. LinkedHashMap底层实现？用在什么场景？
12. 讲一下TreeMap？为什么要自定义排序？
13. TreeMap底层是如何保证元素不重复的？
14. Arraylist和Linkedlist区别，底层实现？Arraylist是如何扩容的？
15. ThreadLocal使用场景
    使用时有什么需要注意的（内存泄漏）
16. 往Map存放自定义的类型，有什么需要注意的
17. ConcurrentHashMap怎么保证线程安全的
    已经用了synchronized，为什么还要用CAS呢
    扩容是怎么保证线程安全的
    如果一个ConcurrentHashMap在被多个线程操作，在进行扩容操作时会有几个线程在处理
    （这块看过源码，所有细节全答上来了）
18. java多线程场景我们选用什么List
19. JDK动态代理，不实现接口就不能做代理了吗，为什么
20. Java为什么不可以多继承
21. 4. Java语言的泛型是怎么实现的？为了解决什么问题而出现的？泛型的效率一定很低吗？
22. 1. HashMap jdk1.7/8有什么区别？元素数量下降长会变回链表吗？
23. 2. HashMap在多线程场景下使用，jdk7/8有都什么问题？问题有什么区别？
24. 3. ConcurrentHashMap怎么保证线程安全的？1.7的分段锁怎么实现的？
25. 读写锁 及其扩展
26. Trie树时间复杂度，实现原理，Trie树比HashMap的优势【不会】
27. 7、String类型为什么用final修饰了【不会】
28. 12、了解红黑树吗【不了解】
29. 17、如何比较一个类中两个对象，Comparable和Comparator接口
30. 对象头
31. Java会不会出现内存泄漏
32. CopyOnWriteList和ConcurrentHashMap原理















### reference answer
18. CopyOnWriteArrayList：CopyOnWriteArrayList是一个线程安全的List实现，适用于读多写少的场景。它通过在写操作时创建一个新的副本来实现线程安全，因此读操作不会被阻塞。适用于需要高效读取的场景，但写操作的性能较低。

Vector：Vector是一个传统的线程安全的List实现，它使用了同步方法来保证线程安全。适用于需要线程安全且对性能要求不高的场景。

Collections.synchronizedList：可以使用Collections.synchronizedList方法将普通的List转换为线程安全的List。它使用了同步块来保证线程安全。适用于对性能要求不高的场景。

