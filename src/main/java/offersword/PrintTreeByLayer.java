package offersword;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author Yasin Zhang
 */
public class PrintTreeByLayer {
    ArrayList<ArrayList<Integer>> solutinon(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(pRoot);
        while(!queue.isEmpty()) {
            ArrayDeque<TreeNode> queue2 = new ArrayDeque<>();
            ArrayList<Integer> layerNodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                layerNodes.add(cur.val);
                if (cur.left != null) {
                    queue2.offer(cur.left);
                }
                if (cur.right != null) {
                    queue2.offer(cur.right);
                }
            }

            queue = queue2;
            result.add(layerNodes);
        }

        return result;
    }
}
