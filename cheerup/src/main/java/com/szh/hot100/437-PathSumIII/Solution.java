package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III (路径总和 III)
 * 
 * 题目链接：https://leetcode.cn/problems/path-sum-iii/
 * 
 * 解法：前缀和 + 递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    private int count = 0;
    private Map<Long, Integer> prefixSum = new HashMap<>();
    
    /**
     * 最优解：前缀和 + 递归
     * 使用前缀和记录从根节点到当前节点的路径和
     */
    public int pathSum(TreeNode root, int targetSum) {
        prefixSum.put(0L, 1);
        dfs(root, 0, targetSum);
        return count;
    }
    
    private void dfs(TreeNode node, long currentSum, int targetSum) {
        if (node == null) {
            return;
        }
        
        currentSum += node.val;
        count += prefixSum.getOrDefault(currentSum - targetSum, 0);
        
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        
        dfs(node.left, currentSum, targetSum);
        dfs(node.right, currentSum, targetSum);
        
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
    }
}
