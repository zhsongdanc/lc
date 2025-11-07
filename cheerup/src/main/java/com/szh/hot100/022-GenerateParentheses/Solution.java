package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 022. Generate Parentheses (括号生成)
 * 
 * 题目链接：https://leetcode.cn/problems/generate-parentheses/
 * 
 * 解法：回溯法
 * 时间复杂度：O(4^n / sqrt(n))
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：回溯法
     * 使用递归回溯生成所有有效的括号组合
     * 约束条件：左括号数量不能超过n，右括号数量不能超过左括号数量
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // 如果当前字符串长度等于2*n，说明已经生成完整的括号组合
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // 如果左括号数量小于n，可以添加左括号
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // 如果右括号数量小于左括号数量，可以添加右括号
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}

