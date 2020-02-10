package offersword;

/**
 * 数字在排序数组中出现的次数
 * @author Yasin Zhang
 */
public class GetNumOfK {
    public int solution(int [] array , int k) {
        int index = binarySearch(array, k);

        if (index == -1) {
            return 0;
        }

        int left = index;
        int right = index;
        while ((left-1) >= 0 && array[left-1] == k) {
            left--;
        }
        while ((right+1) < array.length && array[right+1] == k) {
            right++;
        }

        return right - left + 1;
    }

    private int binarySearch(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
