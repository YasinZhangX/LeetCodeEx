package easy;

/**
 * @author Yasin Zhang
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int result = 0;
        int sign = (x >= 0) ? 1 : -1;
        x = x * sign;

        while(x > 0) {
            if ((long)result * 10 != result * 10) {
                return 0;
            }
            int tmp = result * 10 + x % 10;
            if (((result ^ tmp) & (x ^ tmp)) < 0) {
                return 0;
            } else {
                result = tmp;
            }

            x = x / 10;
        }

        return result * sign;
    }

    public int reverse2(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int sign = (x >= 0) ? 1 : -1;
        x = x * sign;
        int result = 0;
        while (x != 0) {
            int b = x % 10;
            long tmp = ((long)result * 10 + b);
            if (tmp <= Integer.MAX_VALUE) {
                result = (int)tmp;
            } else {
                return 0;
            }
            x = x / 10;
        }

        return result * sign;
    }
}
