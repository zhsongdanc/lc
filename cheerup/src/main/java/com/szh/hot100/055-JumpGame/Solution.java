package com.szh.hot100;

/**
 * 055. Jump Game (跳跃游戏)
 * 
 * 题目链接：https://leetcode.cn/problems/jump-game/
 * 
 * 解法：贪心算法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：贪心算法
     * 维护一个变量记录能够到达的最远位置
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置超过了能到达的最远位置，返回false
            if (i > maxReach) {
                return false;
            }
            // 更新能到达的最远位置
            maxReach = Math.max(maxReach, i + nums[i]);
            // 如果已经能到达最后一个位置，返回true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}

