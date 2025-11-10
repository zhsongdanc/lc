package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation (字母大小写全排列)
 * 
 * 题目链接：https://leetcode.cn/problems/letter-case-permutation/
 * 
 * 解法：回溯法
 * 时间复杂度：O(2^n * n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：回溯法
     * 对于每个字母，可以选择大写或小写
     */
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }
    
    private void backtrack(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        
        if (Character.isLetter(chars[index])) {
            // 转换为小写
            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(chars, index + 1, result);
            
            // 转换为大写
            chars[index] = Character.toUpperCase(chars[index]);
            backtrack(chars, index + 1, result);
        } else {
            // 数字直接跳过
            backtrack(chars, index + 1, result);
        }
    }
}
