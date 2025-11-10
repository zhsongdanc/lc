package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. Target Sum (目标和)
 * 
 * 题目链接：https://leetcode.cn/problems/target-sum/
 * 
 * 解法1：回溯法
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(n)
 * 
 * 解法2：动态规划
 * 时间复杂度：O(n * sum)
 * 空间复杂度：O(sum)
 */
public class Solution {
    
    private int count = 0;
    
    /**
     * 解法1：回溯法
     */
    public int findTargetSumWays1(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }
    
    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        
        backtrack(nums, target, index + 1, sum + nums[index]);
        backtrack(nums, target, index + 1, sum - nums[index]);
    }
    
    /**
     * 解法2：动态规划（最优解）
     * 转换为0-1背包问题：找到和为(sum+target)/2的子集数量
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
            return 0;
        }
        
        int positiveSum = (sum + target) / 2;
        int[] dp = new int[positiveSum + 1];
        dp[0] = 1;
        
        for (int num : nums) {
            for (int j = positiveSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[positiveSum];
    }
}
