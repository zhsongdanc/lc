package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 017. Letter Combinations of a Phone Number (电话号码的字母组合)
 * 
 * 题目链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 
 * 解法：回溯法
 * 时间复杂度：O(4^n * n)，其中 n 是输入数字的长度
 * 空间复杂度：O(n)
 */
public class Solution {
    
    private static final String[] LETTERS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    /**
     * 最优解：回溯法
     * 使用递归回溯生成所有可能的字母组合
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }
    
    private void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        String letters = LETTERS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

