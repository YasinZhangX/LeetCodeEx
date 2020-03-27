package coding;

import offersword.MatchPattern;

import java.util.Scanner;

/**
 * 输入一个 n 和 3*n 的矩阵，然后每一列中选出一个数，组成长度为 n 的数组 B，使得 |b_i - b_i-1| 的和最小
5
  3  4  5  6  7
  8  9 10 11 12
 13 14 10 12 11
 *
 * @author Yasin Zhang
 */
public class BestGroup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[][] matrix = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int[][] dp = new int[3][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][i] = Math.min(Math.min(dp[0][i-1]+Math.abs(matrix[j][i] - matrix[0][i-1]),
                                    dp[1][i-1]+Math.abs(matrix[j][i] - matrix[1][i-1])),
                                    dp[2][i-1]+Math.abs(matrix[j][i] - matrix[2][i-1]));
            }
        }

        int res = Math.min(Math.min(dp[0][n-1], dp[1][n-1]), dp[2][n-1]);
        System.out.println(res);
    }
}
