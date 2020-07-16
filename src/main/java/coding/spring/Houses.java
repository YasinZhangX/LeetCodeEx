package coding.spring;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Houses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }
            ArrayList<Integer> result = new ArrayList<>();
            solution(h, result);
            results.add(result);
        }

        for (ArrayList<Integer> list : results) {
            for (int i = 0; i < list.size()-1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(list.size()-1));
        }
    }

    private static void solution(int[] h, ArrayList<Integer> result) {
        int[] left = new int[h.length];
        int[] right = new int[h.length];

        int leftBarrier = -1;
        left[0] = 0;
        for (int i = 1; i < h.length; i++) {
            if (h[i] >= h[i-1]) {
                left[i] = left[i-1] + 1;
                if (leftBarrier >= 0 && h[i] > h[leftBarrier]) {
                    int j = leftBarrier;
                    while (j >= 0 && h[j] <= h[i]) {
                        j--;
                        left[i]++;
                    }
                }
            } else {
                leftBarrier = i-1;
                left[i] = 0;
            }
        }

        int rightBarrier = h.length;
        right[h.length-1] = 0;
        for (int i = h.length-2; i >= 0; i--) {
            if (h[i] >= h[i+1]) {
                right[i] = right[i+1] + 1;
                if (rightBarrier < h.length && h[i] > h[rightBarrier]) {
                    int j = rightBarrier;
                    while (j < h.length && h[j] <= h[i]) {
                        j++;
                        right[i]++;
                    }
                }
            } else {
                rightBarrier = i+1;
                right[i] = 0;
            }
        }

        for (int i = 0; i < left.length; i++) {
            result.add(left[i] + right[i]);
        }
    }
}
