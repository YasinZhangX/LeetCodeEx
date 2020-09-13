package Utils;

import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class SortUtils {
    public static int[] mergeSort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        return mergeSort(arr, start, end);
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return arr;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        merge(arr, start, mid, end);

        return arr;
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int k = 0;
        int i = start;
        int j = mid+1;
        int[] helper = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                helper[k] = arr[i];
                i++;
            } else {
                helper[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            helper[k] = arr[i];
            k++;
            i++;
        }
        while (j <= end) {
            helper[k] = arr[j];
            k++;
            j++;
        }

        System.arraycopy(helper, 0, arr, start, end-start+1);
    }


}
