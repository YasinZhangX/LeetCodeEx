package offersword;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Yasin Zhang
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> solution(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        innerFindPath(root, target, new ArrayList<Integer>(), 0, paths);

        paths.sort((Comparator<ArrayList<?>>) (o1, o2) -> (o1.size() >= o2.size()) ? -1 : 1);
        return paths;
    }

    private void innerFindPath(TreeNode root, int target,
                               ArrayList<Integer> path, Integer pathSum,
                               ArrayList<ArrayList<Integer>> paths) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> curPath = new ArrayList<>(path);
        curPath.add(root.val);
        if ((pathSum + root.val) == target) {
            if (root.left == null && root.right == null) {
                paths.add(0, new ArrayList<Integer>(curPath));
            }
            return;
        } else if ((pathSum + root.val) > target) {
            return;
        } else {
            innerFindPath(root.left, target, curPath, (pathSum + root.val), paths);
            innerFindPath(root.right, target, curPath, (pathSum + root.val), paths);
        }
    }
}
