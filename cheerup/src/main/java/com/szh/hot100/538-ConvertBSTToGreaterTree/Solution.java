package com.szh.hot100;

/**
 * 538. Convert BST to Greater Tree (把二叉搜索树转换为累加树)
 * 
 * 题目链接：https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * 
 * 解法：反序中序遍历
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
    
    private int sum = 0;
    
    /**
     * 最优解：反序中序遍历
     * 从右到左遍历BST，累加节点值
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
