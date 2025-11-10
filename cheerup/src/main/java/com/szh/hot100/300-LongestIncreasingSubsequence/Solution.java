package com.szh.hot100;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence (最长递增子序列)
 * 
 * 题目链接：https://leetcode.cn/problems/longest-increasing-subsequence/
 * 
 * 解法1：动态规划
 * 时间复杂度：O(n²)
 * 空间复杂度：O(n)
 * 
 * 解法2：动态规划 + 二分查找（最优解）
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 解法1：动态规划
     * dp[i] 表示以nums[i]结尾的最长递增子序列的长度
     */
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
    
    /**
     * 解法2：动态规划 + 二分查找（最优解）
     * 维护一个数组tails，tails[i]表示长度为i+1的递增子序列的最小末尾元素
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        
        for (int num : nums) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (left == len) {
                len++;
            }
        }
        
        return len;
    }
}

