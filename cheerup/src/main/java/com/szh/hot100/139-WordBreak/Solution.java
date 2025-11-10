package com.szh.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break (单词拆分)
 * 
 * 题目链接：https://leetcode.cn/problems/word-break/
 * 
 * 解法：动态规划
 * 时间复杂度：O(n²)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：动态规划
     * dp[i] 表示字符串s的前i个字符能否被字典中的单词拆分
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
