package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element (多数元素)
 * 
 * 题目链接：https://leetcode.cn/problems/majority-element/
 * 
 * 解法1：哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法2：Boyer-Moore投票算法（最优解）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 解法1：哈希表
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
    
    /**
     * 解法2：Boyer-Moore投票算法（最优解）
     * 维护一个候选众数和计数器，遍历数组，如果当前元素等于候选，计数器+1，否则-1
     * 当计数器为0时，更新候选为当前元素
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}

