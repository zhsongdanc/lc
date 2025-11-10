package com.szh.hot100;

/**
 * 072. Edit Distance (编辑距离)
 * 
 * 题目链接：https://leetcode.cn/problems/edit-distance/
 * 
 * 解法：动态规划
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * dp[i][j] 表示 word1 的前 i 个字符转换为 word2 的前 j 个字符所需的最少操作数
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        // 初始化：空字符串转换为另一个字符串需要插入所有字符
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符相同，不需要操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 字符不同，取三种操作的最小值
                    // 1. 替换：dp[i-1][j-1] + 1
                    // 2. 删除：dp[i-1][j] + 1
                    // 3. 插入：dp[i][j-1] + 1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        
        return dp[m][n];
    }
}

