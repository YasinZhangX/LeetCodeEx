package coding.practice;

/**
 * @author Yasin Zhang
 */
public class AdventureCar {
    public static void main(String[] args) {
        int[][] map = {{10, 1, 30, 10, 1, 10, 1, 1}, {20, 1, 1, 30, 1, 1, 10, 1}, {10, 50, 1, 1, 1, 1, 1, 100},
            {20, 10, 20, 20, 1, 1, 1, 100}, {20, 10, 10, 10, 1, 1, 100, 1}, {30, 30, 30, 20, 100, 1, 1, 0}};
//        int[][] map = {{10, 1, 30}, {20, 1, 1}};
        int e0 = 15;
        int x = 0;
        int l = 45;
        int m = map.length;
        int n = map[0].length;

        int[][] cost = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = 0;
        dfs(map, cost, 0, 0, e0, x, l);

        System.out.println(cost[m-1][n-1]);
    }

    public static void dfs(int[][] map, int[][] cost, int i, int j, int e, int x, int l) {
        int m = map.length;
        int n = map[0].length;
        if (i == m-1 && j == n-1) {
            return;
        }

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        for (int k = 0; k < 5; k++) {
            if (k == 4) {
                if (x > 0 && e < l) {
                    e = l;
                    dfs(map, cost, i, j, e, x, l);
                }
            } else {
                int[] direction = new int[]{di[k], dj[k]};
                int[] next = new int[]{i, j};
                int tmpE = drive(map, cost, i, j, e, direction, next);
                int ni = next[0];
                int nj = next[1];
                if (ni != i || nj != j) {
                    dfs(map, cost, ni, nj, tmpE, x, l);
                }
            }
        }
    }

    public static int drive(int[][] map, int[][] cost, int i, int j, int e, int[] direction, int[] next) {
        int originI = i;
        int originJ = j;
        int m = map.length;
        int n = map[0].length;
        int ni = i + direction[0];
        int nj = j + direction[1];
        int ne;

        while (ni >= 0 && ni < m && nj >= 0 && nj < n) {
            ne = e - map[ni][nj];
            if (ne < 0) {
                break;
            }

            if (cost[ni][nj] > cost[i][j] + 1) {
                cost[ni][nj] = cost[i][j] + 1;
            } else {
                next[0] = originI;
                next[1] = originJ;
                break;
            }

            i = ni;
            j = nj;
            e = ne;
            ni = i + direction[0];
            nj = j + direction[1];
        }

        next[0] = i;
        next[1] = j;
        return e;
    }
}
