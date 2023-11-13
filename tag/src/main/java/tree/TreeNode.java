package tree;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/20 10:51
 */

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
