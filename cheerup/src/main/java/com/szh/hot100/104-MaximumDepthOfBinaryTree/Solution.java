package com.szh.hot100;

/**
 * 104. Maximum Depth of Binary Tree (二叉树的最大深度)
 * 
 * 题目链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/
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
    
    /**
     * 最优解：递归
     * 最大深度 = 1 + max(左子树最大深度, 右子树最大深度)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

