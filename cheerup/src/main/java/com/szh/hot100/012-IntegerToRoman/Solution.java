package com.szh.hot100;

/**
 * 012. Integer to Roman (整数转罗马数字)
 * 
 * 题目链接：https://leetcode.cn/problems/integer-to-roman/
 * 
 * 解法：贪心算法
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：贪心算法
     * 从大到小使用所有可能的罗马数字组合
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        
        return sb.toString();
    }
}

