package coding.practice;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class Test {
    public static void main(String[] args) {
        LinkedHashSet<TreeNode> nodes = new LinkedHashSet<>();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t2.parent = t1;
        t1.right = t3;
        t3.parent = t1;
        t2.left = t4;
        t4.parent = t2;
        t2.right = t5;
        t5.parent = t2;
        t3.left = t6;
        t6.parent = t3;
        t3.right = t7;
        t7.parent = t3;
        nodes.add(t1);
        nodes.add(t2);
        nodes.add(t3);
        nodes.add(t4);
        nodes.add(t5);
        nodes.add(t6);
        nodes.add(t7);

        System.out.println(solution(nodes, t1));
    }

    public static int solution(LinkedHashSet<TreeNode> nodes, TreeNode root) {
        List<TreeNode> leaves = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left == null && node.right == null) {
                leaves.add(node);
            }
        }

        int res = Integer.MAX_VALUE;
        for (TreeNode leaf : leaves) {
            List<TreeNode> path = getPath(leaf);
            int count = 0;
            for (TreeNode node : nodes) {
                if (!path.contains(node) && path.contains(node.parent)) {
                    count++;
                }
            }
            res = Math.min(count, res);
        }

        return res;
    }

    public static List<TreeNode> getPath(TreeNode leaf) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode cur = leaf;
        while (cur != null) {
            path.add(cur);
            cur = cur.parent;
        }

        return path;
    }
}
