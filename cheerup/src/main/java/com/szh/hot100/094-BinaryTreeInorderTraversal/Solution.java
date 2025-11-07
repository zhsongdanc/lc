package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 094. Binary Tree Inorder Traversal (二叉树的中序遍历)
 * 
 * 题目链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 
 * 解法1：递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法2：迭代（栈）
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
     * 解法1：递归
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
    
    /**
     * 解法2：迭代（栈）
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        
        return result;
    }
}

