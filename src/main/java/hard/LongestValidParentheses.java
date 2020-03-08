package hard;

import java.util.Stack;

/**
 * 最长有效括号
 * @author Yasin Zhang
 */
public class LongestValidParentheses {
    /**
     * 动态规划解法
     */
    public int solution1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i-1 >= 0) {
                    if (s.charAt(i-1) == '(') {
                        dp[i] = dp[i-2] + 2;
                    } else if (s.charAt(i-1) == ')') {
                        if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                            if (i - dp[i-1] - 2 >= 0) {
                                dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2];
                            } else {
                                dp[i] = dp[i-1] + 2;
                            }
                        }
                    }
                }
            }

            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    /**
     * 通过辅助栈实现
     */
    public int solution2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    int length = i - stack.peek();
                    if (max < length) {
                        max = length;
                    }
                } else {
                    stack.push(i);
                }
            }
        }

        return max;
    }

    /**
     * 左右扫描法
     * 从左到右：左括号数一定会大于等于右括号数，否则不有效
     * 从右到左：右括号数一定会大于等于左括号数，否则不有效
     */
    public int solution3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left*2);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left*2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return max;
    }
}
