package com.szh.hot100;

/**
 * 042. Trapping Rain Water (接雨水)
 * 
 * 题目链接：https://leetcode.cn/problems/trapping-rain-water/
 * 
 * 解法1：双指针法（最优解）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 
 * 解法2：动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法3：单调栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 解法1：双指针法（最优解）
     * 使用两个指针从两端向中间移动，维护左右最大高度
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        
        return result;
    }
    
    /**
     * 解法2：动态规划
     * 分别计算每个位置左右的最大高度
     */
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return result;
    }
}

