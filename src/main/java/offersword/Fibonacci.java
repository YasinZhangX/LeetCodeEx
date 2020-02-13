package offersword;

/**
 * @author Yasin Zhang
 */
public class Fibonacci {
    public int solution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        return solution(n-1) + solution(n-2);
    }

    public int solution_better(int n) {
        int[] result = {0, 1};
        if (n <= 1) {
            return result[n];
        }

        for (int i = 2; i < n; i++) {
            int fibN = result[0] + result[1];

            result[0] = result[1];
            result[1] = fibN;
        }

        return result[1];
    }
}
