package offersword;

import common.TreeNode;

/**
 * @author Yasin Zhang
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            return (isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right))
                || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
        } else {
            return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
        }
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
