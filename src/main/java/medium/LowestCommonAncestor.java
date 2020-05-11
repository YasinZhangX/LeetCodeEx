package medium;

import common.TreeNode;

/**
 * @author Yasin Zhang
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor_Another(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor_Another(root.left, p, q);
        TreeNode right = lowestCommonAncestor_Another(root.right, p, q);

        if ((left == p || left == q) && (right == p || right == q)) {
            return root;
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val) {
            if (containsNode(root.left, q) || containsNode(root.right, q)) {
                return p;
            }
        }

        if (root.val == q.val) {
            if (containsNode(root.left, p) || containsNode(root.right, p)) {
                return q;
            }
        }

        if ((containsNode(root.left, p) || containsNode(root.right, p))
            && (containsNode(root.left, q) || containsNode(root.right, q))) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
            return root;
        }

        return null;
    }

    public boolean containsNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root.val == p.val) {
            return true;
        }

        return containsNode(root.left, p) || containsNode(root.right, p);
    }
}
