package com.szh.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones (宝石与石头)
 * 
 * 题目链接：https://leetcode.cn/problems/jewels-and-stones/
 * 
 * 解法：哈希表
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(m)
 */
public class Solution {
    
    /**
     * 最优解：哈希表
     * 使用Set存储宝石类型，然后统计stones中宝石的数量
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }
        
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }
        
        return count;
    }
}
