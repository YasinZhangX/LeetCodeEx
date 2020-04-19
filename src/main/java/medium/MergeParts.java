package medium;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class MergeParts {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        ArrayList<Pair> pairs = new ArrayList<>(intervals.length);
        for (int[] pair : intervals) {
            pairs.add(new Pair(pair[0], pair[1]));
        }
        pairs.sort(Comparator.comparingInt(o -> o.left));

        Iterator<Pair> iterator = pairs.iterator();
        Pair pre = iterator.next();
        while (iterator.hasNext()) {
            Pair cur = iterator.next();
            if (cur.left <= pre.right) {
                iterator.remove();
                pre.right = Math.max(cur.right, pre.right);
            } else {
                pre = cur;
            }
        }

        int[][] result = new int[pairs.size()][2];
        for (int i = 0; i < pairs.size(); i++) {
            result[i][0] = pairs.get(i).left;
            result[i][1] = pairs.get(i).right;
        }

        return result;
    }

    static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 思路相同，但是空间需求更少，代码也更为简洁
     */
    public int[][] merge_better(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[][] merge = new int[intervals.length][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (index == 0 || merge[index-1][1] < interval[0]) {
                merge[index++] = interval;
            } else {
                merge[index-1][1] = Math.max(merge[index-1][1], interval[1]);
            }
        }

        int[][] res = new int[index][2];
        System.arraycopy(merge, 0, res, 0, index);

        return res;
    }

    /**
     * 双数组，隔位比较，减少了操作
     */
    public int[][] merge_fast(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        while (i < len) {

            int st = start[i];
            while (i < len - 1 && end[i] >= start[i + 1]) {
                i++;
            }
            int en = end[i];
            int[] interv = new int[2];
            interv[0] = st;
            interv[1] = en;
            list.add(interv);
            i++;
        }
        int index = 0;
        int[][] res = new int[list.size()][2];//生成结果数组
        while (!list.isEmpty()) {
            res[index++] = list.removeFirst();
        }
        return res;
    }
}
