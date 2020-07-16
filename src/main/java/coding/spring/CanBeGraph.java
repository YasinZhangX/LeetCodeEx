package coding.spring;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 木棒拼图
5
1 1
1 1
1 1
2 1
1 2
 * @author Yasin Zhang
 */
public class CanBeGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        for (int i = 0; i < n; i++) {
            int type = in.nextInt();
            int x = in.nextInt();

            if (type == 1) {
                sum = sum + x;
                q.add(x);
            } else {
                if (q.isEmpty()) {
                    System.out.println("NO");
                } else {
                    q.remove(x);
                    sum = sum - x;
                }
            }
            check(q, sum);
        }
    }

    private static void check(PriorityQueue<Integer> q, int sum) {
        int tmp = sum - q.peek();
        if (q.size() >= 3 && q.peek() < tmp) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
