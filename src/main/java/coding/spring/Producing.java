package coding.spring;

/**
 * @author Yasin Zhang
 */
public class Producing {
    /**
     *
     * @param n int整型 第n天
     * @return int整型
     */
    public int solution (int n) {
        int d = (int) Math.sqrt(2.0 * n);
        if ((d + 1) * d * 0.5 > n) {
            d = d - 1;
        }

        int remain = n - (int) (d * (d+1) * 0.5);
        return helper(d) + remain * (d+1);
    }

    private int helper(int d) {
        if (d == 1) {
            return 1;
        }

        return helper(d-1) + d * d;
    }

    public static void main(String[] args) {
        Producing alg = new Producing();
        int result = alg.solution(5);
        System.out.println(result);
    }
}
