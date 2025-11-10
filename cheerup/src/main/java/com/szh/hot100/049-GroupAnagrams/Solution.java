package com.szh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 049. Group Anagrams (字母异位词分组)
 * 
 * 题目链接：https://leetcode.cn/problems/group-anagrams/
 * 
 * 解法：哈希表
 * 时间复杂度：O(n * k * log k)，其中 n 是字符串数组的长度，k 是字符串的最大长度
 * 空间复杂度：O(n * k)
 */
public class Solution {
    
    /**
     * 最优解：使用哈希表
     * 将每个字符串排序后作为key，相同key的字符串归为一组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}

