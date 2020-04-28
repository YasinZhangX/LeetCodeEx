package coding;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class TwoStackRealizeQueue {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static int top;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String q = in.nextLine();
            if (q.startsWith("add")) {
                int x = Integer.parseInt(q.substring(4));
                add(x);
            } else if (q.startsWith("poll")) {
                poll();
            } else if (q.startsWith("peek")) {
                System.out.println(peek());
            }
        }
    }

    private static void add(int x) {
        if (stack1.isEmpty()) {
            top = x;
        }

        stack1.push(x);
    }

    private static void poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        stack2.pop();
    }

    private static int peek() {
        if (stack2.isEmpty()) {
            return top;
        }

        return stack2.peek();
    }
}
