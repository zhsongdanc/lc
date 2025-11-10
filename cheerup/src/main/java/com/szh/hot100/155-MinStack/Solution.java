package com.szh.hot100;

import java.util.Stack;

/**
 * 155. Min Stack (最小栈)
 * 
 * 题目链接：https://leetcode.cn/problems/min-stack/
 * 
 * 解法：使用辅助栈
 * 时间复杂度：O(1) 所有操作
 * 空间复杂度：O(n)
 */
public class Solution {
    
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }
        
        public void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }
}

