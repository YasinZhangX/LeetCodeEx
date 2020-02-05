package offersword;

import common.TreeNode;

/**
 * @author Yasin Zhang
 */
public class Convert {
    public TreeNode solution(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        convertToList(pRootOfTree, null);

        TreeNode curNode = pRootOfTree;
        while (curNode.left != null) {
            curNode = curNode.left;
        }

        return curNode;
    }

    private TreeNode convertToList(TreeNode root, TreeNode lastNodeInList) {
        if (root == null) {
            return null;
        }

        TreeNode lastNodeInSublist = lastNodeInList;
        if (root.left != null) {
            lastNodeInSublist = convertToList(root.left, lastNodeInList);
        }

        root.left = lastNodeInSublist;
        if (lastNodeInSublist != null) {
            lastNodeInSublist.right = root;
        }

        lastNodeInSublist = root;
        if (root.right != null) {
            lastNodeInSublist = convertToList(root.right, root);
        }

        return lastNodeInSublist;
    }
}
