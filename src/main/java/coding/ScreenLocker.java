package coding;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

/**
 * 现有一个 3x3 规格的 Android 智能手机锁屏程序和两个正整数 m 和 n ，
 * 请计算出使用最少m 个键和最多 n个键可以解锁该屏幕的所有有效模式总数。
 * 其中有效模式是指：
 * 1、每个模式必须连接至少m个键和最多n个键；
 * 2、所有的键都必须是不同的；
 * 3、如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择，不允许跳过非选择键（如图）；
 * 4、顺序相关，单键有效（这里可能跟部分手机不同）。
 *
 * 输入：m,n
 * 代表允许解锁的最少m个键和最多n个键
 * 输出：
 * 满足m和n个键数的所有有效模式的总数
 *
 * @author Yasin Zhang
 */
public class ScreenLocker {
    /**
     * 实现方案
     * @param m int整型 最少m个键
     * @param n int整型 最多n个键
     * @return int整型
     */
    public int solution (int m, int n) {
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += helper(i);
        }

        return sum;
    }

    int pointRes = 0;
    private int helper(int k) {
        if (k <= 0) {
            return 0;
        }

        int res = 0;

        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 1);

        pointRes = 0;
        boolean[][] visited1 = new boolean[3][3];
        visited1[p1.i][p1.j] = true;
        backtrace(p1, k-1, visited1);
        res += pointRes*4;

        pointRes = 0;
        boolean[][] visited2 = new boolean[3][3];
        visited2[p2.i][p2.j] = true;
        backtrace(p2, k-1, visited2);
        res += pointRes*4;

        pointRes = 0;
        boolean[][] visited3 = new boolean[3][3];
        visited3[p3.i][p3.j] = true;
        backtrace(p3, k-1, visited3);
        res += pointRes;

        return res;
    }

    private void backtrace(Point point, int k, boolean[][] visited) {
        if (k == 0) {
            pointRes++;
            return;
        }

        for (Direction direction : directions) {
            Point next = direction.addCurDirection(point);
            if (next.isValid()) {
                if (!visited[next.i][next.j]) {
                    visited[next.i][next.j] = true;
                    backtrace(next, k-1, visited);
                    visited[next.i][next.j] = false;
                } else {
                    Point next2 = direction.addCurDirection(next);
                    if (next2.isValid() && !visited[next2.i][next2.j]) {
                        visited[next2.i][next2.j] = true;
                        backtrace(next2, k-1, visited);
                        visited[next2.i][next2.j] = false;
                    }
                }
            }
        }
    }

    static List<Direction> directions = new ArrayList<>(8);

    static {
        directions.add(new Direction(-1, 0));
        directions.add(new Direction(1, 0));
        directions.add(new Direction(0, -1));
        directions.add(new Direction(0, 1));
        directions.add(new Direction(-1, -1));
        directions.add(new Direction(-1, 1));
        directions.add(new Direction(1, -1));
        directions.add(new Direction(1, 1));
        directions.add(new Direction(-2, -1));
        directions.add(new Direction(-2, 1));
        directions.add(new Direction(2, -1));
        directions.add(new Direction(2, 1));
        directions.add(new Direction(-1, -2));
        directions.add(new Direction(1, -2));
        directions.add(new Direction(-1, 2));
        directions.add(new Direction(1, 2));
    }

    static class Point {
        private final int i;
        private final int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        protected boolean isValid() {
            return i >= 0 && i <= 2 && j >= 0 && j <= 2;
        }
    }

    static class Direction {
        private final int di;
        private final int dj;

        Direction(int di, int dj) {
            this.di = di;
            this.dj = dj;
        }

        protected Point addCurDirection(Point p) {
            return new Point(p.i + di, p.j + dj);
        }
    }

    public static void main(String[] args) {
        ScreenLocker alg = new ScreenLocker();
        int result = alg.solution(2, 2);
        System.out.println(result);
    }
}
