package offersword;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class HasSubtreeTest {

    @Test
    public void solution() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;

        TreeNode n22 = new TreeNode(2);
        TreeNode n33 = new TreeNode(3);
        TreeNode n44 = new TreeNode(4);
        n22.left = n33;
        n22.right = n44;

        HasSubtree alg = new HasSubtree();
        System.out.println(alg.hasSubtree(n1, n22));
    }
}
