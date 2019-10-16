package hard;

/**
 * @author Yasin Zhang
 */
public class MyAtoi {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int j = 0;
        char first = str.charAt(0);
        if (!(first == '+' || first == '-'
            || (first >= '0' && first <= '9'))) {
            return 0;
        }

        int sign = 1;
        if (first == '-') {
            sign = -1;
            j++;
        } else if (first == '+') {
            j++;
        }

        int result = 0;
        for (int i = j; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (curChar >= '0' && curChar <= '9') {
                int r = curChar - '0';
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && r > 7)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + r;
            } else {
                break;
            }
        }

        return result * sign;
    }
}
