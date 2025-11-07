package com.szh.hot100;

/**
 * 101. Symmetric Tree (对称二叉树)
 * 
 * 题目链接：https://leetcode.cn/problems/symmetric-tree/
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
     * 判断左右子树是否镜像对称
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}

