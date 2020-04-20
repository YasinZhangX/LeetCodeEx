package medium;

import common.TreeNode;

/**
 * @author Yasin Zhang
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer larger) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left, lower, root.val)) {
            return false;
        }
        if (!isValidBST(root.right, root.val, larger)) {
            return false;
        }

        return (lower == null || root.val > lower)
            && (larger == null || root.val < larger);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        IsValidBST alg = new IsValidBST();
        System.out.println(alg.isValidBST(n1));
    }
}
