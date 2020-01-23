package common;

/**
 * @author Yasin Zhang
 */
public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
