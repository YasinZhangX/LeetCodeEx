package coding.test;

/**
 * 最小积分
 * 左上到右下的最少积分，从X到Y，积分为|X-Y|
 * @author Yasin Zhang
 */
public class MinPoint {
    public int solution(int[][] map) {
        int n = map.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        dfs(map, dp, 0, 0);

        return dp[n-1][n-1];
    }

    private void dfs(int[][] map, int[][] dp, int i, int j) {
        int n = map.length;
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                int point = Math.abs(map[ni][nj] - map[i][j]);
                int newPoint = point + dp[i][j];
                if (newPoint < dp[ni][nj]) {
                    dp[ni][nj] = newPoint;
                    dfs(map, dp, ni, nj);
                }
            }
        }
    }

    public static void main(String[] args) {
        MinPoint alg = new MinPoint();
        int[][] map = {{1, 2, 4}, {1, 3, 1}, {1, 2, 1}};
        int ans = alg.solution(map);
        System.out.println(ans);
    }
}
