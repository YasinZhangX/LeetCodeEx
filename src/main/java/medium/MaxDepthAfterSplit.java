package medium;

import java.util.Stack;

/**
 * 有效括号的嵌套深度
 * @author Yasin Zhang
 */
public class MaxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                stack.add(i);
            } else {
                if (stack.isEmpty()) {
                    return null;
                } else {
                    int top = stack.pop();
                    if (stack.size() % 2 == 0) {
                        result[top] = 1;
                        result[i] = 1;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            return null;
        }

        return result;
    }
}
