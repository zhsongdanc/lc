package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements (前 K 个高频元素)
 * 
 * 题目链接：https://leetcode.cn/problems/top-k-frequent-elements/
 * 
 * 解法：哈希表 + 堆
 * 时间复杂度：O(n log k)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：哈希表 + 最小堆
     * 使用哈希表统计频率，使用最小堆维护前k个高频元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }
        
        return result;
    }
}

