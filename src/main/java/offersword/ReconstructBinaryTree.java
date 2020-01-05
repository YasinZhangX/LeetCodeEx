package offersword;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *
 * @author Yasin Zhang
 */
public class ReconstructBinaryTree {
    public TreeNode solution(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        List<Integer> inList = new ArrayList<>(in.length);
        for (int value : in) {
            inList.add(value);
        }
        TreeNode root = recurseBuildTree(pre, inList);

        return root;
    }

    TreeNode recurseBuildTree(int[] pre, List<Integer> inList) {
        if (pre == null || pre.length == 0) {
            return null;
        }

        TreeNode node = new TreeNode(pre[0]);
        int index = inList.indexOf(pre[0]);
        node.left = recurseBuildTree(Arrays.copyOfRange(pre, 1, index+1), inList.subList(0, index));
        node.right = recurseBuildTree(Arrays.copyOfRange(pre, index+1, pre.length), inList.subList(index+1, inList.size()));

        return node;
    }
}
