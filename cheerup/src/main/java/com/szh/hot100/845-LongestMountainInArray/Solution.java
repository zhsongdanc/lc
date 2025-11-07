package com.szh.hot100;

/**
 * 845. Longest Mountain in Array (数组中的最长山脉)
 * 
 * 题目链接：https://leetcode.cn/problems/longest-mountain-in-array/
 * 
 * 解法：双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：双指针
     * 找到每个山峰，然后向两边扩展
     */
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                // 找到山峰，向两边扩展
                int left = i - 1;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                
                int right = i + 1;
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}
