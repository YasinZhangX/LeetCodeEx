package medium;

/**
 * @author Yasin Zhang
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        int[] result = new int[1];
        visited[0][0] = true;
        result[0]++;
        dfs(0, 0, k, visited, result);

        return result[0];
    }

    private void dfs(int i, int j, int k, boolean[][] visited, int[] result) {
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int m = 0; m < 4; m++) {
            int ni = i + di[m];
            int nj = j + dj[m];

            if (isValid(ni, nj, k, visited)) {
                visited[ni][nj] = true;
                result[0]++;
                dfs(ni, nj, k, visited, result);
            }
        }
    }

    private boolean isValid(int i, int j, int k, boolean[][] visited) {
        int m = visited.length;
        int n = visited[0].length;
        if (!(i >= 0 && i < m && j >= 0 && j < n && !visited[i][j])) {
            return false;
        }

        int sum = 0;
        while (i != 0) {
            sum = sum + i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum = sum + j % 10;
            j = j / 10;
        }

        return (sum <= k);
    }
}
