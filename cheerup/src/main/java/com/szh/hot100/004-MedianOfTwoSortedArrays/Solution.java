package com.szh.hot100;

/**
 * 004. Median of Two Sorted Arrays (寻找两个正序数组的中位数)
 * 
 * 题目链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 
 * 解法1：合并数组法
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(m + n)
 * 
 * 解法2：二分查找法（最优解）
 * 时间复杂度：O(log(min(m, n)))
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 解法1：合并数组法
     * 合并两个有序数组，然后找中位数
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;
        
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        int len = merged.length;
        if (len % 2 == 0) {
            return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
        } else {
            return merged[len / 2];
        }
    }
    
    /**
     * 解法2：二分查找法（最优解）
     * 使用二分查找在较短的数组上查找分割点
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保nums1是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }
        
        return 0.0;
    }
}

