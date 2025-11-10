package com.szh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 056. Merge Intervals (合并区间)
 * 
 * 题目链接：https://leetcode.cn/problems/merge-intervals/
 * 
 * 解法：排序 + 合并
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：排序 + 合并
     * 1. 按照区间的起始位置排序
     * 2. 遍历区间，如果当前区间与前一个区间重叠，则合并
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        // 按照起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                // 重叠，合并区间
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // 不重叠，添加当前区间，更新current
                result.add(current);
                current = intervals[i];
            }
        }
        
        result.add(current);
        
        return result.toArray(new int[result.size()][]);
    }
}

