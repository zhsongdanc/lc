package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 013. Roman to Integer (罗马数字转整数)
 * 
 * 题目链接：https://leetcode.cn/problems/roman-to-integer/
 * 
 * 解法：哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：从左到右遍历，如果当前值小于下一个值，则减去当前值，否则加上当前值
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        
        return result;
    }
}

