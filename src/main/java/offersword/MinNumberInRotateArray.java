package offersword;

/**
 * @author Yasin Zhang
 */
public class MinNumberInRotateArray {
    public int solution(int [] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] > array[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return array[end];
    }
}
