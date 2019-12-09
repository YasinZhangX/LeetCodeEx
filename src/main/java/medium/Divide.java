package medium;

/**
 * 29. 两数相除
 *
 * @author Yasin Zhang
 */
public class Divide {
    public int solution1(int dividend, int divisor) {
        long result;
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;
        if (m < n) {
            return 0;
        }

        long tmp = n;
        long divisorBit = 1;
        while (m > (tmp * 2)) {
            tmp = tmp * 2;
            divisorBit = divisorBit * 2;
        }
        result = divisorBit + solution1((int)(m - tmp), (int)n);
        result = sign * result;
        result = Math.min(result, Integer.MAX_VALUE);
        return (int) result;
    }
}
