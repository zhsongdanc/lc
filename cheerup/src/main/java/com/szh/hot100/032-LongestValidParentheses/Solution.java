package com.szh.hot100;

import java.util.Stack;

/**
 * 032. Longest Valid Parentheses (最长有效括号)
 * 
 * 题目链接：https://leetcode.cn/problems/longest-valid-parentheses/
 * 
 * 解法1：栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法2：动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法3：双指针（最优解）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 解法1：栈
     * 使用栈存储索引，遇到 '(' 入栈，遇到 ')' 出栈并计算长度
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 初始边界
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // 更新边界
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
    
    /**
     * 解法2：动态规划
     * dp[i] 表示以 i 结尾的最长有效括号长度
     */
    public int longestValidParentheses2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        
        return maxLen;
    }
}

