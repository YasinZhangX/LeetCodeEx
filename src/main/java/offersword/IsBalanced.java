package offersword;

import common.TreeNode;

/**
 * @author Yasin Zhang
 */
public class IsBalanced {

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
