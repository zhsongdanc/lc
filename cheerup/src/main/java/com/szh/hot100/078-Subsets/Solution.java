package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 078. Subsets (子集)
 * 
 * 题目链接：https://leetcode.cn/problems/subsets/
 * 
 * 解法：回溯法
 * 时间复杂度：O(2^n * n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：回溯法
     * 对于每个元素，可以选择加入或不加入当前子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}

