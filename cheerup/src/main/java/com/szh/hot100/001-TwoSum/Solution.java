package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 001. Two Sum (两数之和)
 * 
 * 题目链接：https://leetcode.cn/problems/two-sum/
 * 
 * 解法1：暴力枚举法
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 * 
 * 解法2：哈希表法（最优解）
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 解法1：暴力枚举法
     * 遍历数组，对于每个元素，查找是否存在另一个元素使得两者之和等于target
     */
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
    /**
     * 解法2：哈希表法（最优解）
     * 使用哈希表存储已遍历的元素及其索引，对于当前元素，查找target - nums[i]是否在哈希表中
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

