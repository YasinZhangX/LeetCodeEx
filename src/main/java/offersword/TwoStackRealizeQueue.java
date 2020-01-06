package offersword;

import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class TwoStackRealizeQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (!stack2.isEmpty()) {
            for (int i = 0; i < stack2.size(); i++) {
                stack1.push(stack2.pop());
            }
        }

        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("empty stack");
            } else {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    stack2.push(stack1.pop());
                }
            }
        }

        return stack2.pop();
    }
}
