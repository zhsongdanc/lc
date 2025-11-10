package com.szh.hot100;

/**
 * 647. Palindromic Substrings (回文子串)
 * 
 * 题目链接：https://leetcode.cn/problems/palindromic-substrings/
 * 
 * 解法：中心扩展法
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    private int count = 0;
    
    /**
     * 最优解：中心扩展法
     * 从每个可能的中心向两边扩展，统计回文子串的数量
     */
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);     // 奇数长度
            expandAroundCenter(s, i, i + 1);  // 偶数长度
        }
        return count;
    }
    
    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
