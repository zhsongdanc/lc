### problems list
1.分布式锁
2.崩溃恢复，原子广播

```bash
1. epoch，leader启动时使用了learner中最大的epoch作为新的epoch(这是在选举完leader之后的启动流程)

problems:
1. 如何实现投票的第一轮，第二轮的？
2.收到选举轮次小的，发出自己？收到observer，发出自己
```
### reference answer
1.https://www.cnblogs.com/crazymakercircle/p/14504520.html#autoid-h2-5-0-0
### 
先简单过一下，
