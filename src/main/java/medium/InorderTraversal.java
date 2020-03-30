package medium;

import common.TreeNode;

import java.util.*;

/**
 * 二叉树的中序遍历
 * @author Yasin Zhang
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            result.add(cur.val);

            cur = cur.right;
        }

        return result;
    }
}
