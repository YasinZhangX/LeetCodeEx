package offersword;

/**
 * @author Yasin Zhang
 */
public class MinNumberInRotateArray {
    public int solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (array[start] >= array[end]) {  // 判断是否为有序数组，即旋转0个
            if (end - start == 1) { // end指向了最小的一个
                mid = end;
                break;
            }

            mid = (start + end) / 2;
            if (array[start] == array[end] && array[mid] == array[start]
                && array[mid] == array[end]) {
                return orderNSolution(array, start, end);
            }
            if (array[mid] >= array[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return array[mid];
    }

    private int orderNSolution(int[] array, int start, int end) {
        int min = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }
}
