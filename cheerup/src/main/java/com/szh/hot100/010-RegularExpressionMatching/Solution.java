package com.szh.hot100;

/**
 * 010. Regular Expression Matching (正则表达式匹配)
 * 
 * 题目链接：https://leetcode.cn/problems/regular-expression-matching/
 * 
 * 解法：动态规划
 * 时间复杂度：O(m * n)，其中 m 和 n 分别是字符串 s 和 p 的长度
 * 空间复杂度：O(m * n)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // 空字符串匹配空模式
        dp[0][0] = true;
        
        // 处理模式 p 开头可能有多个 "x*" 的情况
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '*') {
                    // '*' 匹配零个前面的字符
                    dp[i][j] = dp[i][j - 2];
                    // '*' 匹配一个或多个前面的字符
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}

