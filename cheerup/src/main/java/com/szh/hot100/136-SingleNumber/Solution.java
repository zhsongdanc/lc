package com.szh.hot100;

/**
 * 136. Single Number (只出现一次的数字)
 * 
 * 题目链接：https://leetcode.cn/problems/single-number/
 * 
 * 解法：位运算（异或）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：位运算（异或）
     * 利用异或运算的性质：a ^ a = 0, a ^ 0 = a
     * 所有出现两次的数字异或后为0，最后剩下的就是只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

