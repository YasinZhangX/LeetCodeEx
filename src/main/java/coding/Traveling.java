package coding;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Traveling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[][] prices = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prices[i][j] = in.nextInt();
            }
        }

        int V = (int) Math.pow(2, n-1);
        int[][] dp = new int[n][V];

        // 计算回程价格
        for (int i = 0; i < n; i++) {
            dp[i][0] = prices[i][0];
        }

        // 计算各个子项，从上到下，从左到右
        for (int j = 1; j < V; j++) {
            // 处理一列
            for (int i = 0; i < n; i++) {
                // 初始化值
                dp[i][j] = Integer.MAX_VALUE;

                // 子集中不包含当前城市，即可以前往当前子集
                // 通过 j 的二进制表示子集，当前位是1，表示对应城市在子集中
                if ((j & (1 << (i-1))) == 0) {
                    // 轮询子集，由于是从城市 0 出发，所以只需要查看三个城市
                    for (int k = 1; k < n; k++) {
                        // 子集中有城市k
                        if ((j & (1 << (k-1))) > 0) {
                            // 从子集中排除城市k
                            int S = j ^ (1 << (k-1));
                            // 动态规划求最小值
                            dp[i][j] = Math.min(dp[i][j], (prices[i][k] + dp[k][S]));
                        }
                    }
                }
            }
        }

        System.out.println(dp[0][V-1]);
    }


    private static int totalCities;
    private static int min = Integer.MAX_VALUE;

    public static void test(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        totalCities = n;
        in.nextLine();

        int[][] prices = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prices[i][j] = in.nextInt();
            }
        }

        boolean[] traveled = new boolean[n];
        traveled[0] = true;
        int cities = 1;
        int curCity = 0;
        int curPrice = 0;
        for (int i = 0; i < n; i++) {
            if (!traveled[i]) {
                curPrice += prices[curCity][i];
                traveled[i] = true;
                cities++;
                backTrace(prices, traveled, cities, i, curPrice);
                cities--;
                traveled[i] = false;
                curPrice -= prices[curCity][i];
            }
        }

        System.out.println(min);
    }

    private static void backTrace(int[][] prices, boolean[] traveled, int cities,
                                  int curCity, int curPrice) {
        if (cities == totalCities) {
            curPrice += prices[curCity][0];
            min = Math.min(min, curPrice);
        }

        for (int i = 0; i < totalCities; i++) {
            if (!traveled[i]) {
                curPrice += prices[curCity][i];
                traveled[i] = true;
                cities++;
                backTrace(prices, traveled, cities, i, curPrice);
                cities--;
                traveled[i] = false;
                curPrice -= prices[curCity][i];
            }
        }
    }
}
