package com.szh.hot100;

/**
 * 617. Merge Two Binary Trees (合并二叉树)
 * 
 * 题目链接：https://leetcode.cn/problems/merge-two-binary-trees/
 * 
 * 解法：递归
 * 时间复杂度：O(min(m, n))
 * 空间复杂度：O(min(m, n))
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
     * 如果两个节点都不为空，合并值；如果有一个为空，返回另一个
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
}
