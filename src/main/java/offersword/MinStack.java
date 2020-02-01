package offersword;

import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class MinStack {
    private Stack<Long> stack = new Stack<>();;
    private long min;

    public void push(int node) {
        if (stack.empty()) {
            stack.push((long)0);
            min = node;
        } else {
            stack.push((long)node-min);
            if (node < min) {
                min = node;
            }
        }
    }

    public void pop() {
        if (!stack.empty()) {
            if (stack.peek() < 0) {
                min = min - stack.peek();
            }
            stack.pop();
        }
    }

    public int top() {
        if (stack.empty()) {
            throw new RuntimeException("empty stack");
        } else {
            if (stack.peek() > 0) {
                return (int)(min + stack.peek());
            } else {
                return (int)min;
            }
        }
    }

    public int min() {
        if (stack.empty()) {
            throw new RuntimeException("empty stack");
        } else {
            return (int)min;
        }
    }
}
