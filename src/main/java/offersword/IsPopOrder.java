package offersword;

import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class IsPopOrder {
    public boolean solution(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] != popA[j]) {
                stack.push(pushA[i]);
            } else {
                j++;
            }
        }

        while (!stack.isEmpty() && j < popA.length) {
            if (stack.pop() != popA[j]) {
                return false;
            } else {
                j++;
            }
        }

        return true;
    }
}
