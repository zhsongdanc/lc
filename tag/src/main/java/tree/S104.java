package tree;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/20 11:00
 */
public class S104 {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }
}
