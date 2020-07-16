package coding.spring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class SaveMoney {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            nodes.add(new Node(in.nextInt(), 1));
        }
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(in.nextInt(), 2));
        }
        nodes.sort(Comparator.comparingInt(o -> o.val));

        int result = 0;
        for (int i = 0; i < nodes.size(); i++) {
            Node cur = nodes.get(i);
            if (cur.type == 2) {
                Node pre = null;
                for (int j = i-1; j >= 0; j--) {
                    if (nodes.get(j).type == 1) {
                        pre = nodes.get(j);
                        break;
                    }
                }
                if (pre == null) {
                    result += cur.val;
                } else {
                    result += cur.val - pre.val;
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int val;
        int type;

        Node(int val, int type) {
            this.val = val;
            this.type = type;
        }
    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        PriorityQueue<Integer> q1 = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        int[] c = new int[n];
        for (int i = 0; i < m; i++) {
            q1.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        int result = 0;
        for (int value : c) {
            int max = getMax(new PriorityQueue<>(q1), value);
            result += value - max;
        }

        System.out.println(result);
    }

    private static int getMax(PriorityQueue<Integer> q, int x) {
        while (!q.isEmpty()) {
            if (x < q.peek()) {
                q.poll();
            } else {
                return q.peek();
            }
        }

        return 0;
    }
}
