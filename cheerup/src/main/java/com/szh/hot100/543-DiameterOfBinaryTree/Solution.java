package com.szh.hot100;

/**
 * 543. Diameter of Binary Tree (二叉树的直径)
 * 
 * 题目链接：https://leetcode.cn/problems/diameter-of-binary-tree/
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
    
    private int maxDiameter = 0;
    
    /**
     * 最优解：递归
     * 对于每个节点，计算经过该节点的最长路径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        
        // 经过当前节点的最长路径
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
