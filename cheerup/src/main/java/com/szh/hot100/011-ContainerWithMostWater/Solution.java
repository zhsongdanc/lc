package com.szh.hot100;

/**
 * 011. Container With Most Water (盛最多水的容器)
 * 
 * 题目链接：https://leetcode.cn/problems/container-with-most-water/
 * 
 * 解法1：暴力枚举
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 * 
 * 解法2：双指针法（最优解）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 解法1：暴力枚举
     * 枚举所有可能的容器组合
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    
    /**
     * 解法2：双指针法（最优解）
     * 使用两个指针从两端向中间移动，每次移动高度较小的指针
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            
            // 移动高度较小的指针，因为移动高度较大的指针不会得到更大的面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}

