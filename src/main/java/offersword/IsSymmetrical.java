package offersword;

import common.TreeNode;

import java.util.ArrayDeque;

/**
 * @author Yasin Zhang
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return false;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(pRoot.left);
        q.addLast(pRoot.right);
        while (!q.isEmpty()) {
            ArrayDeque<TreeNode> newq = new ArrayDeque<>();
            for (int i = 0; i < q.size()/2; i++) {
                TreeNode n1 = q.removeFirst();
                TreeNode n2 = q.removeLast();
                if (n1 != null && n2 != null) {
                    if (n1.val == n2.val) {
                        newq.addFirst(n1.right);
                        newq.addFirst(n1.left);
                        newq.addLast(n2.left);
                        newq.addLast(n2.right);
                    } else {
                        return false;
                    }
                } else if (n1 == null && n2 == null) {
                    continue;
                } else {
                    return false;
                }
            }
            q = newq;
        }

        return true;
    }
}
