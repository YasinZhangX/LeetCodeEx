package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class IntervalIntersection {
    public int[][] solution(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                ans.add(new int[]{lo, hi});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        List<int[]> A = new ArrayList<>();
        A.add(new int[]{1, 2});
        A.add(new int[]{4, 5});
        A.add(new int[]{8, 8});
        List<int[]> B = new ArrayList<>();
        B.add(new int[]{1, 4});
        B.add(new int[]{6, 8});

        List<int[]> ans = helper(A, B);
        List<Integer> result = new ArrayList<>();
        for (int[] inter: ans) {
            for (int i = inter[0]; i <= inter[1]; i++) {
                result.add(i);
            }
        }

        System.out.println(Arrays.toString(result.toArray()));
    }

    public static List<int[]> helper(List<int[]> A, List<int[]> B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.size() && j < B.size()) {
            int lo = Math.max(A.get(i)[0], B.get(j)[0]);
            int hi = Math.min(A.get(i)[1], B.get(j)[1]);
            if (lo <= hi) {
                ans.add(new int[]{lo, hi});
            }

            if (A.get(i)[1] < B.get(j)[1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
