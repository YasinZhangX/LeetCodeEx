package utils.graph;

import java.util.Arrays;

/**
 * 二分图的最大匹配，匈牙利算法
 * @author Yasin Zhang
 */
public class MaxMatch {

    public static void main(String[] args) {
        int[][] graph = {{1, 1, 0, 1, 0, 0, 0},
                         {0, 1, 0, 0, 1, 0, 0},
                         {1, 0, 0, 1, 0, 0, 1},
                         {0, 0, 1, 1, 0, 1, 0},
                         {0, 0, 0, 1, 0, 0, 0},
                         {0, 0, 0, 1, 0, 0, 0}};
        int nx = 6;
        int ny = 7;
        int[] cx = new int[nx];
        Arrays.fill(cx, -1);
        int[] cy = new int[ny];
        Arrays.fill(cy, -1);
        boolean[] visit = new boolean[nx + ny];

        int ans = maxMatch(graph, nx, ny, cx, cy, visit);
        System.out.println(ans);
    }

    /**
     * 寻找最大匹配的数量
     *
     * int N = 10; // 总的节点数
     * int[][] graph = new int[N][N]; // 图的邻接矩阵
     * int nx, ny;
     * int[] cx = new int[N]; // cx[i]表示最终求得的最大匹配中与xi匹配的Y节点
     * int[] cy = new int[N];
     * boolean[] visit = new boolean[N];  // 顶点访问矩阵，true表示访问过
     */
    public static int maxMatch(int[][] graph, int nx, int ny, int[] cx, int[] cy, boolean[] visit) {
        int res = 0;
        for (int i = 0; i < nx; i++) {
            if (path(i, graph, ny, cx, cy, visit)) { // 找到一条增广路就可以匹配数量加1
                res++;
            }
        }

        return res;
    }

    /**
     * 通过 u 节点找一条增广路径，找到则返回true，反之返回false
     */
    private static boolean path(int u, int[][] graph, int ny, int[] cx, int[] cy, boolean[] visit) {
        for (int v = 0; v < ny; v++) {
            if (graph[u][v] == 1 && !visit[v]) {  // 与 u 邻接且未被访问
                if (visit[v]) {
                    if (path(cy[v], graph, ny, cx, cy, visit)) {  // 已经匹配了但可以找到一条增广路
                        return true;
                    }
                } else {
                    visit[v] = true;  // 标记 v 节点被访问
                    if (cy[v] == -1 || path(cy[v], graph, ny, cx, cy, visit)) {  // v 节点没有匹配或者已经匹配了但可以找到一条增广路
                        cx[u] = v;
                        cy[v] = u;
                        return true;
                    }
                }

            }
        }

        return false; // 不存在增广路
    }

}
