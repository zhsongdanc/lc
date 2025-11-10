package com.szh.hot100;

/**
 * 064. Minimum Path Sum (最小路径和)
 * 
 * 题目链接：https://leetcode.cn/problems/minimum-path-sum/
 * 
 * 解法：动态规划
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)，可以优化到O(n)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * dp[i][j] 表示到达 (i, j) 的最小路径和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

