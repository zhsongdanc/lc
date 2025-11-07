package com.szh.hot100;

/**
 * 581. Shortest Unsorted Continuous Subarray (最短无序连续子数组)
 * 
 * 题目链接：https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 * 
 * 解法：一次遍历
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：一次遍历
     * 找到无序子数组的最小值和最大值，然后找到它们在正确位置
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        
        // 找到无序子数组的最小值
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        
        flag = false;
        // 找到无序子数组的最大值
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        
        int left = 0, right = n - 1;
        // 找到最小值应该插入的位置
        while (left < n && nums[left] <= min) {
            left++;
        }
        // 找到最大值应该插入的位置
        while (right >= 0 && nums[right] >= max) {
            right--;
        }
        
        return right - left < 0 ? 0 : right - left + 1;
    }
}
