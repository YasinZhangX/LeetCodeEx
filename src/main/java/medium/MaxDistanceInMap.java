package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 地图分析
 * @author Yasin Zhang
 */
public class MaxDistanceInMap {
    public int solution(int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = grid.length;
        int[][] distance = new int[n][n];
        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    distance[i][j] = 0;
                    q.add(new Point(i, j, 0));
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            Point top = q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = top.x + dx[k];
                int nj = top.y + dy[k];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n
                    && grid[ni][nj] == 0) {
                    if (top.distance + 1 < distance[ni][nj]) {
                        distance[ni][nj] = top.distance + 1;
                        q.add(new Point(ni, nj, distance[ni][nj]));
                    }
                }
            }
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, distance[i][j]);
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    static class Point {
        int x;
        int y;
        int distance;
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
