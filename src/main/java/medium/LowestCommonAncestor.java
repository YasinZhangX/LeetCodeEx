package medium;

import common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * @author Yasin Zhang
 */
public class LowestCommonAncestor {
    public int getDistance(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = lowestCommonAncestor_Another(root, p, q);

        int left = getDepth(ancestor, p) - 1;
        int right = getDepth(ancestor, q) - 1;

        return left + right;
    }

    public int getDepth(TreeNode root, TreeNode p) {
        if (root == null) {
            return 0;
        }

        if (root.val == p.val) {
            return 1;
        }

        int left = getDepth(root.left, p);
        int right = getDepth(root.right, p);

        if (left != 0 || right != 0) {
            return left + right + 1;
        }

        return 0;
    }

    public TreeNode lowestCommonAncestor_Another(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor_Another(root.left, p, q);
        TreeNode right = lowestCommonAncestor_Another(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if ((left.val == p.val || left.val == q.val) && (right.val == p.val || right.val == q.val)) {
            return root;
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
