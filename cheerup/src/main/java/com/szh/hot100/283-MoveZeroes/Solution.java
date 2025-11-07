package com.szh.hot100;

/**
 * 283. Move Zeroes (移动零)
 * 
 * 题目链接：https://leetcode.cn/problems/move-zeroes/
 * 
 * 解法：双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：双指针
     * 使用一个指针记录非零元素应该放置的位置
     */
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        
        // 将所有非零元素移到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        
        // 将剩余位置填充为0
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

