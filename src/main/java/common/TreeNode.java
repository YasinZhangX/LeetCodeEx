package common;

import java.util.LinkedList;

/**
 * @author Yasin Zhang
 */
public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode parent = null;
    public TreeNode(int x) {
        val = x;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode generateTree(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int start = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }

                if (start < nums.length) {
                    Integer left = nums[start++];
                    if (left != null) {
                        cur.left = new TreeNode(left);
                    }
                    queue.add(cur.left);
                }
                if (start < nums.length) {
                    Integer right = nums[start++];
                    if (right != null) {
                        cur.right = new TreeNode(right);
                    }
                    queue.add(cur.right);
                }
            }
        }

        return root;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
