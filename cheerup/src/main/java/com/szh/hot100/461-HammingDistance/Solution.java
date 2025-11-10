package com.szh.hot100;

/**
 * 461. Hamming Distance (汉明距离)
 * 
 * 题目链接：https://leetcode.cn/problems/hamming-distance/
 * 
 * 解法：位运算
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：位运算
     * 先异或，然后统计1的个数
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        
        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }
        
        return count;
    }
    
    /**
     * 方法2：使用内置函数
     */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
