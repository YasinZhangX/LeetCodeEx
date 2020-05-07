package medium;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        HashSet<Integer> removeIndexes = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack.push(i);
            } else if (str[i] == ')') {
                if (stack.isEmpty()) {
                    removeIndexes.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            removeIndexes.add(stack.pop());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (!removeIndexes.contains(i)) {
                builder.append(str[i]);
            }
        }

        return builder.toString();
    }
}
