package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 046. Permutations (全排列)
 * 
 * 题目链接：https://leetcode.cn/problems/permutations/
 * 
 * 解法：回溯法
 * 时间复杂度：O(n! * n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：回溯法
     * 使用递归回溯生成所有可能的排列
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            backtrack(result, current, nums);
            current.remove(current.size() - 1);
        }
    }
}

