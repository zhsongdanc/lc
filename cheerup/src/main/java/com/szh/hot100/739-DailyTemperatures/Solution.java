package com.szh.hot100;

import java.util.Stack;

/**
 * 739. Daily Temperatures (每日温度)
 * 
 * 题目链接：https://leetcode.cn/problems/daily-temperatures/
 * 
 * 解法：单调栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：单调栈
     * 使用栈存储索引，维护一个单调递减的栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        
        return result;
    }
}
