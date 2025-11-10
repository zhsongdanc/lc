package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III (打家劫舍 III)
 * 
 * 题目链接：https://leetcode.cn/problems/house-robber-iii/
 * 
 * 解法：动态规划（树形DP）
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
    
    /**
     * 最优解：动态规划（树形DP）
     * 对于每个节点，返回两个值：[不偷当前节点的最大值, 偷当前节点的最大值]
     */
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] robHelper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        
        // 不偷当前节点：可以偷左右子节点（取最大值）
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点：不能偷左右子节点
        int rob = node.val + left[0] + right[0];
        
        return new int[]{notRob, rob};
    }
}
