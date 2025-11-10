package com.szh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 015. 3Sum (三数之和)
 * 
 * 题目链接：https://leetcode.cn/problems/3sum/
 * 
 * 解法：排序 + 双指针
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)（不考虑返回值的空间）
 */
public class Solution {
    
    /**
     * 最优解：排序 + 双指针
     * 1. 先对数组排序
     * 2. 固定第一个数，使用双指针寻找另外两个数
     * 3. 注意去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 跳过重复的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}

