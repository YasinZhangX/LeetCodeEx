package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 452. 用最少数量的箭引爆气球
 * @author Yasin Zhang
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int arrowNum = 1;
        int firstEnd = points[0][1];
        for (int[] point : points) {
            int curStart = point[0];
            int curEnd = point[1];

            if (firstEnd < curStart) {
                arrowNum++;
                firstEnd = curEnd;
            }
        }

        return arrowNum;
    }

    public int findMinArrowShots_Complex(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        LinkedList<int[]> intervals = new LinkedList<>();
        for (int[] point : points) {
            intervals.offer(point);
        }

        ArrayList<int[]> usefulIntervals = new ArrayList<>();
        while (!intervals.isEmpty()) {
            if (intervals.size() == 1) {
                usefulIntervals.add(intervals.poll());
                continue;
            }

            int[] point1 = intervals.pollFirst();
            int[] point2 = intervals.pollFirst();

            if (point1[1] >= point2[0]) {
                int[] tmp = new int[]{point2[0], Math.min(point1[1], point2[1])};
                intervals.addFirst(tmp);
            } else {
                usefulIntervals.add(point1);
                intervals.addFirst(point2);
            }
        }

        return usefulIntervals.size();
    }
}
