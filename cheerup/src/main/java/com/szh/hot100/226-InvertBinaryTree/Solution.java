package com.szh.hot100;

/**
 * 226. Invert Binary Tree (翻转二叉树)
 * 
 * 题目链接：https://leetcode.cn/problems/invert-binary-tree/
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
     * 交换左右子树，然后递归处理左右子树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}

