package medium;

/**
 * @author Yasin Zhang
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0
            || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else {
                    dp[i][j] = getMin(dp, i, j) + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    private int getMin(int[][] dp, int i, int j) {
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if (ni >= 0 && ni < dp.length && nj >= 0 && nj < dp[0].length) {
                min = Math.min(min, dp[ni][nj]);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        MinPathSum alg = new MinPathSum();
        int result = alg.minPathSum(grid);
        System.out.println(result);
    }
}
