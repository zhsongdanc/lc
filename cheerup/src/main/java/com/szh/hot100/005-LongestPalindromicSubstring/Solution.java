package com.szh.hot100;

/**
 * 005. Longest Palindromic Substring (最长回文子串)
 * 
 * 题目链接：https://leetcode.cn/problems/longest-palindromic-substring/
 * 
 * 解法1：中心扩展法
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 * 
 * 解法2：动态规划
 * 时间复杂度：O(n²)
 * 空间复杂度：O(n²)
 * 
 * 解法3：Manacher算法（最优解，但实现复杂）
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 解法1：中心扩展法（推荐）
     * 从每个可能的中心向两边扩展，寻找最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数长度的回文串
            int len1 = expandAroundCenter(s, i, i);
            // 偶数长度的回文串
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    /**
     * 解法2：动态规划
     * dp[i][j] 表示 s[i...j] 是否为回文串
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                
                if (dp[i][j] && len > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        
        return res;
    }
}

