package primary.others;

/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：0 ≤ x, y < 2^31.
 *
 * @author Yasin Zhang
 */
public class Ex2 {

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;

        while (n != 0) {
            n = n & (n-1);
            count++;
        }

        return count;
    }

}
