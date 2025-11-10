package com.szh.hot100;

/**
 * 053. Maximum Subarray (最大子数组和)
 * 
 * 题目链接：https://leetcode.cn/problems/maximum-subarray/
 * 
 * 解法：动态规划（Kadane算法）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：动态规划（Kadane算法）
     * 使用一个变量记录以当前位置结尾的最大子数组和
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // 如果当前和小于0，重新开始计算
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}

