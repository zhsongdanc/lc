### problems list
1. spring、springboot相关不需要深入，常用的熟悉即可
2. mybatis相关可以深入看一下
3. 循环依赖如何处理，如何实现一个三级缓存，都有哪些参数？为什么二级不行
4. Spring Bean的生命周期？串起来具体讲一讲初始化的那一段
5. Spring Boot自动装配原理？使用了哪些注解
6. 是如何通过注解来找对对应的需要装配的类的？
7. SpringMVC执行流程？现在面向接口开发的情况下的执行流程？
8. Spring的二级缓存有什么作用？
9. SpringCloud你了解多少？
10. spring bean初始化过程
11. spring设计模式
12. springboot如何实现自定义注解
13. spring事务如何实现的
14. 开始异步线程方法
15. aop原理？
16. 动态代理底层实现？
17. Spring事务失效场景
18. bean是单例还是多例的，具体怎么修改
19. MyBatis传参有哪几种方式，有什么区别
20. Spring循环依赖
21. 5. Spring的循环依赖是怎么解决的？
22. 13. 什么情况有sql注入风险
23. 2，SpringMVC组件HandlerMapping，SpringBoot监听器扩展（√）
24. 3、自定义starter怎么实现的
25. 4、拦截器执行流程
26. Spring async注解原理
27. 怎么实现AOP，实现动态代理的方式
28. 22. 11，AnnotaionConfigApplicationContext启动流程（默认的bean后置处理器，beanfactory后置处理器，refresh（）关键步骤）（√）
29. springboot事务管理，如何在一个请求的每个事务执行结束后都会重置数据库连接的状态，会还到连接池里面吗
30. springboot启动流程
### reference answer
19.${}可能导致sql注入，#{}可以使用预编译语句，将sql替换，通过setString方法设置参数值，不会直接将
参数拼接到sql中。#{}只会将参数当作字符串

30.https://juejin.cn/post/7035910505810100255
