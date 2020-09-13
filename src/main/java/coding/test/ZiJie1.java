package coding.test;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class ZiJie1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.println(solution(n));
        }
    }

    public static int solution1(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }

        int[] result = {0, 1, 2};
        for (int i = 3; i <= target; i++) {
            int res = result[2] + result[1] - result[0];

            result[0] = result[1];
            result[1] = result[2];
            result[2] = res;
        }

        return result[2];
    }

    public static int solution(int n) {
        if (n < 2) {
            return n;
        }
        int[][] memo = new int[n+1][2];
        memo[0][0] = 1;
        memo[0][1] = 1;
        memo[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i][0] = memo[i-1][0] + memo[i-1][1];
            memo[i][1] = memo[i-2][0];
        }

        return memo[n][0] + memo[n][1];
    }
}
