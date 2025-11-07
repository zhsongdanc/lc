package com.szh.hot100;

/**
 * 033. Search in Rotated Sorted Array (搜索旋转排序数组)
 * 
 * 题目链接：https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 
 * 解法：二分查找
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：二分查找
     * 根据 mid 位置的值和左右边界的关系，判断哪一半是有序的
     * 然后在有序的一半中判断 target 是否在其中
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}

