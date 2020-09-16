package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yasin Zhang
 */
public class EraseOverlapIntervals {
    // 基于起始点的动态规划
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> (interval[0])));

        int[] dp = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int maxNonOverlapNumber = 0;
            for (int j = i-1; j >= 0; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    maxNonOverlapNumber = Math.max(maxNonOverlapNumber, dp[j]);
                    break;
                }
            }

            dp[i] = Math.max((i-1 >=0 ? dp[i-1] : 0), maxNonOverlapNumber + 1);
        }

        return intervals.length - dp[intervals.length - 1];
    }

    // 贪心算法
    public int eraseOverlapIntervals_Greedy(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> (interval[0])));

        int count = 0;
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] >= intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }

        return count;
    }
}
