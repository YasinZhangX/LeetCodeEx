package offersword;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class PrintTreeFromTopToBottom {
    public ArrayList<Integer> solution_better(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            result.add(cur.val);

            if (cur.left != null) {
                q.add(cur.left);
            }

            if (cur.right != null) {
                q.add(cur.right);
            }
        }

        return result;
    }

    public ArrayList<Integer> solution(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        HashMap<Integer, ArrayList<Integer>> layerMap = new HashMap<>();
        getNodesInEachLayer(root, 0, layerMap);

        int i = 0;
        while (layerMap.containsKey(i)) {
            result.addAll(layerMap.get(i));
            i++;
        }

        return result;
    }

    private void getNodesInEachLayer(TreeNode root, int layer, HashMap<Integer, ArrayList<Integer>> map) {
        if (root == null) {
            return;
        }

        if (map.containsKey(layer)) {
            map.get(layer).add(root.val);
        } else {
            ArrayList<Integer> layerNodes = new ArrayList<>();
            layerNodes.add(root.val);
            map.put(layer, layerNodes);
        }

        getNodesInEachLayer(root.left, layer+1, map);
        getNodesInEachLayer(root.right, layer+1, map);
    }
}
