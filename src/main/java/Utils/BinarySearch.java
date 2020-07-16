package Utils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yasin Zhang
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param arr  待搜索的数组
     * @param target  被搜索的值
     * @return 当 target 存在数组中时，返回 target 的下标
     *         当 target 不存在数组中时，返回 -insertionPoint-1
     *         insertionPoint 表示若插入 target，target的对应下标
     *         即 数组下标 insertionPoint 对应的数是第一个大于target的数
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
