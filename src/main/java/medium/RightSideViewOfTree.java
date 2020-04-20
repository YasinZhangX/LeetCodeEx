package medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class RightSideViewOfTree {
    int layers = -1;
    HashMap<Integer, Integer> dict = new HashMap();
    public List<Integer> rightSideView(TreeNode root) {
        searchByLayer(root, 0);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= layers; i++) {
            res.add(dict.get(i));
        }

        return res;
    }

    private void searchByLayer(TreeNode root, int layer) {
        if (root == null) {
            return;
        }

        layers = Math.max(layers, layer);

        searchByLayer(root.right, layer + 1);
        if (!dict.containsKey(layer)) {
            dict.put(layer, root.val);
        }
        searchByLayer(root.left, layer + 1);
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView_better(TreeNode root) {
        helper(root, 0);
        return list;
    }

    public void helper(TreeNode root, int n) {
        if (root == null)
            return;
        // 每一层放一个元素
        if (n == list.size())
            list.add(root.val);
        helper(root.right, n + 1);
        helper(root.left, n + 1);
    }
}
