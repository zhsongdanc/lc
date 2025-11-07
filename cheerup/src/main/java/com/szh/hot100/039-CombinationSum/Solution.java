package com.szh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 039. Combination Sum (组合总和)
 * 
 * 题目链接：https://leetcode.cn/problems/combination-sum/
 * 
 * 解法：回溯法
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(target)
 */
public class Solution {
    
    /**
     * 最优解：回溯法
     * 使用递归回溯生成所有可能的组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 排序以便剪枝
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                          int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(result, current, candidates, remain - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}

