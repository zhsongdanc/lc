package com.szh.hot100;

/**
 * 416. Partition Equal Subset Sum (分割等和子集)
 * 
 * 题目链接：https://leetcode.cn/problems/partition-equal-subset-sum/
 * 
 * 解法：动态规划（0-1背包）
 * 时间复杂度：O(n * sum)
 * 空间复杂度：O(sum)
 */
public class Solution {
    
    /**
     * 最优解：动态规划（0-1背包）
     * 转换为0-1背包问题：能否从数组中选出一些数，使得它们的和等于数组总和的一半
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
}
