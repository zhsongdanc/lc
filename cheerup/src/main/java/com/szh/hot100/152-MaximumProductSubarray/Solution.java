package com.szh.hot100;

/**
 * 152. Maximum Product Subarray (乘积最大子数组)
 * 
 * 题目链接：https://leetcode.cn/problems/maximum-product-subarray/
 * 
 * 解法：动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * 由于存在负数，需要同时维护最大值和最小值
     */
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
}
