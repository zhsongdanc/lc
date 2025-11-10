package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal (从前序与中序遍历序列构造二叉树)
 * 
 * 题目链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * 解法：递归 + 哈希表
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
    
    private Map<Integer, Integer> indexMap;
    private int preIndex = 0;
    
    /**
     * 最优解：递归 + 哈希表
     * 使用哈希表存储中序遍历中每个值的位置，递归构建二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = indexMap.get(rootVal);
        
        root.left = buildTree(preorder, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, inorder, rootIndex + 1, inEnd);
        
        return root;
    }
}
