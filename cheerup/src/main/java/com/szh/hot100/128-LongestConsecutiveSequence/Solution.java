package com.szh.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence (最长连续序列)
 * 
 * 题目链接：https://leetcode.cn/problems/longest-consecutive-sequence/
 * 
 * 解法：哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：哈希表
     * 使用Set存储所有数字，对于每个数字，检查它是否是连续序列的起点
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : numSet) {
            // 只从连续序列的起点开始计算
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}

