package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class CombinationSum {
    private List<Long> minRes = new ArrayList<>();
    private long s;
    private long end;

    private void findCombinationSum(long residue, long start, Stack<Long> pre) {
        if (residue == 0) {
            if (minRes.size() == 0) {
                minRes = new ArrayList<>(pre);
            } else {
                if (minRes.size() > pre.size()) {
                    minRes = new ArrayList<>(pre);
                } else if (minRes.size() == pre.size()) {
                    for (int i = 0; i < minRes.size(); i++) {
                        if (minRes.get(i) < pre.get(i)) {
                            break;
                        }
                        if (minRes.get(i) > pre.get(i)) {
                            minRes = new ArrayList<>(pre);
                        }
                    }
                }
            }
            return;
        }

        for (long i = start; i <= end && residue - i >= 0; i++) {
            pre.add(i);
            findCombinationSum(residue - i, i, pre);
            pre.pop();
        }
    }

    public List<Long> combinationSum(long start, long end, long target) {
        long len = end - start + 1;
        if (len <= 0) {
            return minRes;
        }

        this.s = start;
        this.end = end;
        findCombinationSum(target, start, new Stack<>());
        return minRes;
    }
}
