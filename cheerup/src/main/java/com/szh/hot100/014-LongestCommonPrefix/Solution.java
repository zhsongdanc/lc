package com.szh.hot100;

/**
 * 014. Longest Common Prefix (最长公共前缀)
 * 
 * 题目链接：https://leetcode.cn/problems/longest-common-prefix/
 * 
 * 解法1：横向扫描
 * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量
 * 空间复杂度：O(1)
 * 
 * 解法2：纵向扫描
 * 时间复杂度：O(mn)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 解法1：横向扫描
     * 依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        
        return prefix;
    }
    
    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
    
    /**
     * 解法2：纵向扫描（推荐）
     * 从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int length = strs[0].length();
        int count = strs.length;
        
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
}

