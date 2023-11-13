package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/20 10:51
 */
public class S102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);

        }
        while (!queue.isEmpty()) {
            int layerCount = queue.size();
            List<Integer> layerElement = new ArrayList<>();
            for (int i = 0; i < layerCount; i++) {
                TreeNode poll = queue.poll();
                layerElement.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(layerElement);

        }

        return res;
    }
}
