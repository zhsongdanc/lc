package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 076. Minimum Window Substring (最小覆盖子串)
 * 
 * 题目链接：https://leetcode.cn/problems/minimum-window-substring/
 * 
 * 解法：滑动窗口
 * 时间复杂度：O(m + n)，其中 m 和 n 分别是字符串 s 和 t 的长度
 * 空间复杂度：O(m + n)
 */
public class Solution {
    
    /**
     * 最优解：滑动窗口
     * 使用双指针维护一个滑动窗口，用HashMap记录字符出现次数
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // 统计t中每个字符的出现次数
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        // 滑动窗口中的字符统计
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0; // 窗口中满足条件的字符个数
        int start = 0, len = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            // 更新窗口数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                
                char d = s.charAt(left);
                left++;
                
                // 更新窗口数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}

