package coding.test;

import common.TreeNode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Wangyi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        HashMap<Integer, TreeNode> dict = new HashMap<>(m);
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            int parent = Integer.parseInt(parts[0]);
            int child = Integer.parseInt(parts[2]);
            TreeNode parentNode;
            if (dict.containsKey(parent)) {
                parentNode = dict.get(parent);
            } else {
                parentNode = new TreeNode(parent);
                dict.put(parent, parentNode);
            }
            TreeNode childNode;
            if (dict.containsKey(child)) {
                childNode = dict.get(child);
            } else {
                childNode = new TreeNode(child);
                dict.put(child, childNode);
            }

            if (parts[1].equals("left")) {
                parentNode.left = childNode;
            } else if (parts[1].equals("right")) {
                parentNode.right = childNode;
            }
        }

        solution(dict.get(1));
        System.out.println(count);
    }

    static int count = 0;
    private static void solution(TreeNode root) {
        if (root == null) {
            return;
        }

        boolean left = isLeaf(root.left);
        boolean right = isLeaf(root.right);

        if (left && right) {
            count++;
        }

        solution(root.left);
        solution(root.right);
    }

    private static boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }

        return node.left == null && node.right == null;
    }
}
