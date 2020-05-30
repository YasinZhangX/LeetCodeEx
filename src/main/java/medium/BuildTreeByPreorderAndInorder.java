package medium;

import common.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @author Yasin Zhang
 */
public class BuildTreeByPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int pl, int pr,
                            int[] inorder, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }

        int curIndex = il, leftTreeSize = il;
        int cur = preorder[pl];
        TreeNode root = new TreeNode(cur);
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == cur) {
                curIndex = i;
                leftTreeSize = i - il;
                break;
            }
        }

        root.left = helper(preorder, pl+1, pl+leftTreeSize, inorder, il, curIndex-1);
        root.right = helper(preorder, pl+leftTreeSize+1, pr, inorder, curIndex+1, ir);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTreeByPreorderAndInorder alg = new BuildTreeByPreorderAndInorder();
        TreeNode root = alg.buildTree(preorder, inorder);
    }
}
