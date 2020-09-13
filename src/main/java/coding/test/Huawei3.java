package coding.test;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Huawei3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        double[][] pD = new double[n][m];
        double[][] pR = new double[n][m];
        double[][] pS = new double[n][m];
        double[][] dp = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pD[i][j] = sc.nextDouble();
                pR[i][j] = sc.nextDouble();
                pS[i][j] = sc.nextDouble();
            }
        }

        System.out.println(solution(0, 0, m, n, pD, pR, pS, dp));
    }

    private static double solution(int i, int j, int m, int n,
                                   double[][] pD, double[][] pR, double[][] pS,
                                   double[][] dp) {
        if (i > n-1 || j > m-1) {
            return 0;
        }

        if (i == n-1 && j == m-1) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (pS[i][j] == 1) {
            dp[i][j] = 0;
            return 0;
        }

        dp[i][j] = 1 + pR[i][j] * solution(i, j+1, m, n, pD, pR, pS, dp)
            + pD[i][j] * solution(i+1, j, m, n, pD, pR, pS, dp);

        return dp[i][j];
    }
}
