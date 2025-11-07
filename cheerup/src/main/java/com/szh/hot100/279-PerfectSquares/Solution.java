package com.szh.hot100;

import java.util.Arrays;

/**
 * 279. Perfect Squares (完全平方数)
 * 
 * 题目链接：https://leetcode.cn/problems/perfect-squares/
 * 
 * 解法：动态规划
 * 时间复杂度：O(n * sqrt(n))
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * dp[i] 表示和为 i 的完全平方数的最少数量
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}
