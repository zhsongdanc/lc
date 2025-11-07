package com.szh.hot100;

/**
 * 098. Validate Binary Search Tree (验证二叉搜索树)
 * 
 * 题目链接：https://leetcode.cn/problems/validate-binary-search-tree/
 * 
 * 解法：中序遍历
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
    
    private long prev = Long.MIN_VALUE;
    
    /**
     * 最优解：中序遍历
     * 二叉搜索树的中序遍历结果是递增的
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (!isValidBST(root.left)) {
            return false;
        }
        
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        
        return isValidBST(root.right);
    }
}

