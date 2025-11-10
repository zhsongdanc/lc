package com.szh.hot100;

import java.util.Arrays;

/**
 * 062. Unique Paths (不同路径)
 * 
 * 题目链接：https://leetcode.cn/problems/unique-paths/
 * 
 * 解法1：动态规划
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 * 
 * 解法2：动态规划（空间优化）
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(n)
 * 
 * 解法3：组合数学
 * 时间复杂度：O(min(m, n))
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 解法1：动态规划
     * dp[i][j] 表示到达 (i, j) 的路径数
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    /**
     * 解法2：动态规划（空间优化）
     * 只使用一维数组
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}

