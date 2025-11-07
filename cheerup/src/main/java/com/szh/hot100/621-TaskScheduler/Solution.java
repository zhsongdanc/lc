package com.szh.hot100;

import java.util.Arrays;

/**
 * 621. Task Scheduler (任务调度器)
 * 
 * 题目链接：https://leetcode.cn/problems/task-scheduler/
 * 
 * 解法：贪心算法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：贪心算法
     * 找到出现次数最多的任务，计算需要的最短时间
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        
        Arrays.sort(count);
        int maxCount = count[25];
        int maxCountTasks = 0;
        
        for (int i = 25; i >= 0 && count[i] == maxCount; i--) {
            maxCountTasks++;
        }
        
        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxCountTasks);
    }
}
