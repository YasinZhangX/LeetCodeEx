package offersword;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class PrintTreeInZ {
    public ArrayList<ArrayList<Integer>> solution(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        int layer = 1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        while(!stack.isEmpty()) {
            Stack<TreeNode> stack2 = new Stack<>();
            ArrayList<Integer> layerNodes = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                layerNodes.add(cur.val);
                if ((layer & 1) == 1) {
                    if (cur.left != null) {
                        stack2.push(cur.left);
                    }
                    if (cur.right != null) {
                        stack2.push(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        stack2.push(cur.right);
                    }
                    if (cur.left != null) {
                        stack2.push(cur.left);
                    }
                }
            }

            stack = stack2;
            result.add(layerNodes);
            layer++;
        }

        return result;
    }
}
