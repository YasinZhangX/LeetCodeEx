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
}
