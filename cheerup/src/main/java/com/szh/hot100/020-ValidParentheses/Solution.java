package com.szh.hot100;

import java.util.Stack;

/**
 * 020. Valid Parentheses (有效的括号)
 * 
 * 题目链接：https://leetcode.cn/problems/valid-parentheses/
 * 
 * 解法：栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：使用栈
     * 遇到左括号入栈，遇到右括号检查栈顶是否匹配
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}

