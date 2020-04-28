package coding;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class MinDistanceBetweenTwoSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            double min = Double.MAX_VALUE;
            int[][] A = new int[n][2];
            for (int i = 0; i < n; i++) {
                A[i][0] = in.nextInt();
                A[i][1] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int[] b = new int[2];
                b[0] = in.nextInt();
                b[1] = in.nextInt();

                for (int j = 0; j < n; j++) {
                    double distance2 = (A[j][0] - b[0]) * (A[j][0] - b[0])
                        + (A[j][1] - b[1]) * (A[j][1] - b[1]);
                    min = Math.min(min, Math.sqrt(distance2));
                }
            }
            System.out.printf("%.3f\n", min);
        }
    }
}
