package com.szh.hot100;

/**
 * 124. Binary Tree Maximum Path Sum (二叉树中的最大路径和)
 * 
 * 题目链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * 
 * 解法：递归
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
    
    private int maxSum = Integer.MIN_VALUE;
    
    /**
     * 最优解：递归
     * 对于每个节点，计算经过该节点的最大路径和
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // 递归计算左右子树的最大贡献值
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        
        // 经过当前节点的最大路径和
        int priceNewPath = node.val + leftGain + rightGain;
        
        // 更新全局最大路径和
        maxSum = Math.max(maxSum, priceNewPath);
        
        // 返回当前节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
