package hard;

import common.TreeNode;

/**
 * 二叉树中的最大路径和
 * @author Yasin Zhang
 */
public class MaxPathSumInTree {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);

        int crossRootPathSum = left + root.val + right;
        maxSum = Math.max(maxSum, crossRootPathSum);

        return root.val + Math.max(left, right);
    }
}
