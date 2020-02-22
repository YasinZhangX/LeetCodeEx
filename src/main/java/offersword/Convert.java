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

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        convertToList(pRootOfTree, null);

        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }

        return head;
    }

    private TreeNode converToList(TreeNode curNode, TreeNode lastNodeInList) {
        if (curNode == null) {
            return null;
        }

        TreeNode newLastNode = lastNodeInList;
        if (curNode.left != null) {
            newLastNode = convertToList(curNode.left, lastNodeInList);
        }

        curNode.left = newLastNode;
        if (newLastNode != null) {
            newLastNode.right = curNode;
        }

        newLastNode = curNode;
        if (curNode.right != null) {
            convertToList(curNode.right, newLastNode);
        }

        return newLastNode;
    }
}
