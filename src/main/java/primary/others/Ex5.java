package primary.others;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author Yasin Zhang
 */
public class Ex5 {

    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    charStack.push(c);
                    break;

                case ')':
                    if (charStack.isEmpty() || charStack.peek() != '(') {
                        return false;
                    } else {
                        charStack.pop();
                    }
                    break;

                case ']':
                    if (charStack.isEmpty() || charStack.peek() != '[') {
                        return false;
                    } else {
                        charStack.pop();
                    }
                    break;

                case '}':
                    if (charStack.isEmpty() || charStack.peek() != '{') {
                        return false;
                    } else {
                        charStack.pop();
                    }
                    break;
            }
        }

        return charStack.isEmpty();
    }

    public boolean better(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (c == ')' && top != '(')
                    return false;
                if (c == ']' && top != '[')
                    return false;
                if (c == '}' && top != '{')
                    return false;
            }

        }
        return stack.isEmpty();
    }

    public boolean anotherWay(String s) {
        char[] chars = s.toCharArray();//str转数组
        char[] leftArr = new char[chars.length];//缓存chars中的左括号
        char[] arr = new char[128];//存放需要被匹配的括号 right -> left
        arr[')'] = '(';
        arr[']'] = '[';
        arr['}'] = '{';
        int i = -1;
        for (char c : chars) {
            char v = arr[c];
            if (i < 0 || v == 0) {
                leftArr[++i] = c;
            } else if (leftArr[i--] != v) {
                return false;
            }
        }
        return i < 0;
    }

}
