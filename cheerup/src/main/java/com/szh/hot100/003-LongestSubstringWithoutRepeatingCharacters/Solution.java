package com.szh.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 003. Longest Substring Without Repeating Characters (无重复字符的最长子串)
 * 
 * 题目链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 
 * 解法1：滑动窗口 + HashSet
 * 时间复杂度：O(n)
 * 空间复杂度：O(min(m, n))，其中 m 是字符集的大小
 * 
 * 解法2：滑动窗口 + HashMap（最优解）
 * 时间复杂度：O(n)
 * 空间复杂度：O(min(m, n))
 */
public class Solution {
    
    /**
     * 解法1：滑动窗口 + HashSet
     * 使用两个指针维护一个滑动窗口，用HashSet记录窗口中的字符
     */
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // 如果遇到重复字符，移动左指针直到没有重复
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    /**
     * 解法2：滑动窗口 + HashMap（最优解）
     * 使用HashMap记录字符及其最新出现的位置，可以更快地移动左指针
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果字符已存在且在当前窗口内，更新左指针
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}

