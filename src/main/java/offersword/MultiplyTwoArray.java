package offersword;

/**
 * @author Yasin Zhang
 */
public class MultiplyTwoArray {
    public int[] solution(int[] A) {
        if (A == null || A.length <= 1) {
            return null;
        }

        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }

        int tmp = 1;
        for (int i = A.length-2; i >= 0; i--) {
            tmp = tmp * A[i+1];
            B[i] = B[i] * tmp;
        }

        return B;
    }
}
