package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K (和为 K 的子数组)
 * 
 * 题目链接：https://leetcode.cn/problems/subarray-sum-equals-k/
 * 
 * 解法：前缀和 + 哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：前缀和 + 哈希表
     * 使用哈希表记录前缀和出现的次数
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 前缀和为0出现1次
        
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
