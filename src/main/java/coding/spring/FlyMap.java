package coding.spring;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author Yasin Zhang
4 4
# S . .
E # . .
# . . .
. . . .
 */
public class FlyMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Point S = null, E = null;
        char[][] map = new char[n][m];
        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] strs = line.split(" ");
            for(int j = 0; j < strs.length; j++) {
                map[i][j] = strs[j].charAt(0);
                if (map[i][j] == 'S') {
                    S = new Point(i+1, j+1);
                    map[i][j] = '.';
                } else if (map[i][j] == 'E') {
                    E = new Point(i+1, j+1);
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(map, S, E));
    }

    private static int bfs(char[][] map, Point S, Point E) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(S);

        int n = map.length;
        int m = map[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == E.x && cur.y == E.y) {
                return cur.step;
            }

            for (int i = 0; i < 5; i++) {
                if (i != 4) {
                    Point next = new Point(cur.x+dx[i], cur.y+dy[i], cur.fly, cur.step+1);
                    if (isValidPoint(map, next)) {
                        q.offer(next);
                        map[next.x-1][next.y-1] = 'A';
                    }
                } else {
                    int flyX = n + 1 - cur.x;
                    int flyY = m + 1 - cur.y;
                    Point fly = new Point(flyX, flyY, cur.fly+1, cur.step+1);
                    if (isValidPoint(map, fly)) {
                        q.offer(fly);
                        map[fly.x-1][fly.y-1] = 'A';
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isValidPoint(char[][] map, Point point) {
        return point.x > 0 && point.y > 0 && point.x <= map.length && point.y <= map[0].length
            && map[point.x-1][point.y-1] == '.' && point.fly <= 5;
    }

    static class Point {
        int x;
        int y;
        int fly = 0;
        int step = 0;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int fly, int step) {
            this.x = x;
            this.y = y;
            this.fly = fly;
            this.step = step;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + ", " + fly + ", " + step + "]";
        }
    }
}
