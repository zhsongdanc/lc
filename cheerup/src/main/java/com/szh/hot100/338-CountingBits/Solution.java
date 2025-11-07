package com.szh.hot100;

/**
 * 338. Counting Bits (比特位计数)
 * 
 * 题目链接：https://leetcode.cn/problems/counting-bits/
 * 
 * 解法：动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * dp[i] = dp[i >> 1] + (i & 1)
     * 或者 dp[i] = dp[i & (i - 1)] + 1
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // 方法1：右移1位，然后加上最低位
            dp[i] = dp[i >> 1] + (i & 1);
            
            // 方法2：去掉最低位的1，然后加1
            // dp[i] = dp[i & (i - 1)] + 1;
        }
        
        return dp;
    }
}
