package easy;

/**
 * @author Yasin Zhang
 */
public class CanThreePartsEqualSum {
    public boolean solution(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        int sum = 0;
        for (int value : A) {
            sum = sum + value;
        }

        int partSum;
        if (sum % 3 != 0) {
            return false;
        } else {
            partSum = sum / 3;
        }

        int i = 0;
        int j = A.length - 1;

        int sum1 = 0;
        while (i < A.length - 2) {
            sum1 = sum1 + A[i];
            if (sum1 == partSum) {
                break;
            } else {
                i++;
            }
        }

        int sum2 = 0;
        while (j > i) {
            sum2 = sum2 + A[j];
            if (sum2 == partSum) {
                break;
            } else {
                j--;
            }
        }

        return (i+1 < j) && (sum - sum1 - sum2 == partSum);
    }
}
