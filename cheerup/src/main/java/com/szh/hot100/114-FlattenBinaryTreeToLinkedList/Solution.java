package com.szh.hot100;

/**
 * 114. Flatten Binary Tree to Linked List (二叉树展开为链表)
 * 
 * 题目链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
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
    
    private TreeNode prev = null;
    
    /**
     * 最优解：递归（后序遍历）
     * 从右到左进行后序遍历，将节点连接到前一个节点
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
