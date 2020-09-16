package medium;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class LowestCommonAncestorTest {

    @Test
    public void lowestCommonAncestor() {
        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.generateTree(nums);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(8);

        LowestCommonAncestor alg = new LowestCommonAncestor();
        int result = alg.getDistance(root, p, q);
        System.out.println(result);
    }
}
