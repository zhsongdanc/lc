package com.szh.hot100;

/**
 * 238. Product of Array Except Self (除自身以外数组的乘积)
 * 
 * 题目链接：https://leetcode.cn/problems/product-of-array-except-self/
 * 
 * 解法：左右乘积列表
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)（不考虑返回值的空间）
 */
public class Solution {
    
    /**
     * 最优解：左右乘积列表
     * 先计算左侧所有元素的乘积，再计算右侧所有元素的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // 计算左侧所有元素的乘积
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // 计算右侧所有元素的乘积并乘以左侧乘积
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        
        return result;
    }
}

