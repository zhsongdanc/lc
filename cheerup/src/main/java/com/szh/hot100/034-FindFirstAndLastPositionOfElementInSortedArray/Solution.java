package com.szh.hot100;

/**
 * 034. Find First and Last Position of Element in Sorted Array (在排序数组中查找元素的第一个和最后一个位置)
 * 
 * 题目链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * 解法：二分查找
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：二分查找
     * 使用两次二分查找，分别找到第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        
        return result;
    }
    
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        
        return index;
    }
    
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        
        return index;
    }
}

