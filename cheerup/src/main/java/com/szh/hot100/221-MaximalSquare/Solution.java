package com.szh.hot100;

/**
 * 221. Maximal Square (最大正方形)
 * 
 * 题目链接：https://leetcode.cn/problems/maximal-square/
 * 
 * 解法：动态规划
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)，可以优化到O(n)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * dp[i][j] 表示以 (i, j) 为右下角的最大正方形的边长
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}
