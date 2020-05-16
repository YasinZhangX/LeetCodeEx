package coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class BC3Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        ArrayList<Graph> graphs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            boolean added = false;
            for (Graph g : graphs) {
                if (g.contains(a) || g.contains(b)) {
                    g.addPair(a, b);
                    added = true;
                    break;
                }
            }

            if (!added) {
                Graph graph = new Graph();
                graph.addPair(a, b);
                graphs.add(graph);
            }
        }

        int result = 0;
        for (Graph graph : graphs) {
            result += graph.opreNum();
        }

        System.out.println(result);
    }

    static class Graph {
        HashMap<Integer, Integer> sockIndex = new HashMap<>();
        int sum = 0;
        int maxCount = 0;

        public void addPair(int a, int b) {
            int count = sockIndex.getOrDefault(a, 0);
            sockIndex.put(a, count+1);
            maxCount = Math.max(maxCount, count+1);
            count = sockIndex.getOrDefault(b, 0);
            sockIndex.put(b, count+1);
            maxCount = Math.max(maxCount, count+1);

            sum = sum + 2;
        }

        public boolean contains(int a) {
            return sockIndex.containsKey(a);
        }

        public int opreNum() {
            return sum - maxCount;
        }
    }
}
