package com.szh.hot100;

/**
 * 236. Lowest Common Ancestor of a Binary Tree (二叉树的最近公共祖先)
 * 
 * 题目链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
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
        TreeNode(int x) { val = x; }
    }
    
    /**
     * 最优解：递归
     * 如果当前节点是p或q，返回当前节点
     * 如果左右子树都找到了节点，当前节点就是LCA
     * 如果只有一边找到了，返回那一边的结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
}
