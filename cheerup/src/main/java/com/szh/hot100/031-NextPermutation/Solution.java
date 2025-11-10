package com.szh.hot100;

/**
 * 031. Next Permutation (下一个排列)
 * 
 * 题目链接：https://leetcode.cn/problems/next-permutation/
 * 
 * 解法：两遍扫描
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：两遍扫描
     * 1. 从右往左找到第一个降序的位置 i
     * 2. 从右往左找到第一个大于 nums[i] 的位置 j
     * 3. 交换 nums[i] 和 nums[j]
     * 4. 反转 i+1 到末尾的数组
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // 从右往左找到第一个降序的位置
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            // 从右往左找到第一个大于 nums[i] 的位置
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换
            swap(nums, i, j);
        }
        
        // 反转 i+1 到末尾的数组
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

