package primary.others;

/**
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * @author Yasin Zhang
 */
public class Ex3 {

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result + (n & 1);

            n = n >> 1;

            if (i != 31) {
                result = result << 1;
            }
        }

        return result;
    }

    public int better(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result << 1;

            result = result + (n & 1);

            n = n >> 1;
        }

        return result;
    }

}
