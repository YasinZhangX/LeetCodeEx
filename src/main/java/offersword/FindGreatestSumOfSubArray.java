package offersword;

/**
 * @author Yasin Zhang
 */
public class FindGreatestSumOfSubArray {
    public int solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int value : array) {
            if (sum <= 0) {
                sum = value;
            } else {
                sum = sum + value;
            }

            if (sum > result) {
                result = sum;
            }
        }

        return result;
    }
}
