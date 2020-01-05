package offersword;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class ReconstructBinaryTreeTest {

    @Test
    public void solution() {
        ReconstructBinaryTree alg = new ReconstructBinaryTree();

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = alg.solution(pre, in);

        System.out.println("end");
    }
}
