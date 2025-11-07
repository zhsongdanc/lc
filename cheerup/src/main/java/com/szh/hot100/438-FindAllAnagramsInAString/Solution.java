package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String (找到字符串中所有字母异位词)
 * 
 * 题目链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * 
 * 解法：滑动窗口
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：滑动窗口
     * 使用固定大小的滑动窗口，统计窗口中字符的频率
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        
        if (matches(pCount, sCount)) {
            result.add(0);
        }
        
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            
            if (matches(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
    
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}
