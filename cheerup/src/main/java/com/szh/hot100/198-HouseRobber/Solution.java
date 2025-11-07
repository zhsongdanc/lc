package com.szh.hot100;

/**
 * 198. House Robber (打家劫舍)
 * 
 * 题目链接：https://leetcode.cn/problems/house-robber/
 * 
 * 解法：动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：动态规划（空间优化）
     * dp[i] = max(dp[i-1], dp[i-2] + nums[i])
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int prev2 = 0;
        int prev1 = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}

