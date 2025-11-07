package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels (划分字母区间)
 * 
 * 题目链接：https://leetcode.cn/problems/partition-labels/
 * 
 * 解法：贪心算法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：贪心算法
     * 记录每个字符最后出现的位置，然后遍历字符串，找到每个片段的最远边界
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return result;
    }
}
