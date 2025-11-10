package com.szh.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum (滑动窗口最大值)
 * 
 * 题目链接：https://leetcode.cn/problems/sliding-window-maximum/
 * 
 * 解法：单调队列
 * 时间复杂度：O(n)
 * 空间复杂度：O(k)
 */
public class Solution {
    
    /**
     * 最优解：单调队列
     * 使用双端队列维护一个单调递减的队列，队首元素是当前窗口的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 移除窗口外的元素
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 移除小于当前元素的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // 记录窗口最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
