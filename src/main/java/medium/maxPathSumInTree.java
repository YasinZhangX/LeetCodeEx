package medium;

import common.TreeNode;

/**
 * @author Yasin Zhang
 */
public class maxPathSumInTree {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getMaxSum(root);
        return maxSum;
    }

    private int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(getMaxSum(root.left), 0);
        int right = Math.max(getMaxSum(root.right), 0);

        maxSum = Math.max((left + right + root.val),  maxSum);

        return Math.max(left, right) + root.val;
    }
}
