package com.szh.hot100;

/**
 * 070. Climbing Stairs (爬楼梯)
 * 
 * 题目链接：https://leetcode.cn/problems/climbing-stairs/
 * 
 * 解法1：动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法2：动态规划（空间优化）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 解法1：动态规划
     * dp[i] 表示到达第 i 阶的方法数
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    /**
     * 解法2：动态规划（空间优化）
     * 只使用两个变量保存前两个状态
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int first = 1;
        int second = 2;
        
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }
}

