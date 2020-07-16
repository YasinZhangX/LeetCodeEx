package coding.spring;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class RealizeQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            int Q = in.nextInt();
            in.nextLine();
            queue.clear();
            for (int i = 0; i < Q; i++) {
                String q = in.nextLine();
                if (q.startsWith("PUSH")) {
                    int x = Integer.parseInt(q.substring(5));
                    push(x);
                } else if (q.startsWith("POP")) {
                    pop();
                } else if (q.startsWith("TOP")) {
                    System.out.println(top());
                } else if (q.startsWith("SIZE")) {
                    System.out.println(size());
                } else if (q.startsWith("CLEAR")) {
                    clear();
                }
            }
        }
    }

    static LinkedList<Integer> queue = new LinkedList<>();

    private static void push(int x) {
        queue.add(x);
    }

    private static void pop() {
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        queue.pop();
    }

    private static int top() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.peek();
    }

    private static int size() {
        return queue.size();
    }

    private static void clear() {
        queue.clear();
    }
}
