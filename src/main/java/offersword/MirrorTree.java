package offersword;

import common.TreeNode;

import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class MirrorTree {
    public void solution1(TreeNode root) {
        if (root == null) {
            return;
        }

        solution1(root.left);
        solution1(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public void solution2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode tmp = cur.right;
            cur.right = cur.left;
            cur.left = tmp;

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
    }
}
