package offersword;

import common.TreeNode;

/**
 * @author Yasin Zhang
 */
public class IsBalanced {

    public boolean solution_better(TreeNode root) {
        int[] depth = new int[1];
        return isBalanced(root, depth);
    }

    private boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            if (Math.abs(left[0]-right[0]) > 1) {
                return false;
            } else {
                depth[0] = 1 + Math.max(left[0], right[0]);
                return true;
            }
        }

        return false;
    }

    private TreeDepth alg = new TreeDepth();

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = alg.solution(root.left);
        int rightDepth = alg.solution(root.right);

        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        } else {
            return false;
        }
    }
}
