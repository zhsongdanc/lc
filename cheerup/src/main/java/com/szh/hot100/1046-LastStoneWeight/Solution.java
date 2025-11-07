package com.szh.hot100;

import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight (最后一块石头的重量)
 * 
 * 题目链接：https://leetcode.cn/problems/last-stone-weight/
 * 
 * 解法：优先队列（最大堆）
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：优先队列（最大堆）
     * 使用最大堆存储石头，每次取出两个最大的石头进行粉碎
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int stone : stones) {
            heap.offer(stone);
        }
        
        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            
            if (first != second) {
                heap.offer(first - second);
            }
        }
        
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
