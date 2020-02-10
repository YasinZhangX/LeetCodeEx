package offersword;

import java.util.Arrays;

/**
 * 数组中的逆序对
 * @author Yasin Zhang
 */
public class InversePairs {
    public int solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] copy = Arrays.copyOf(array, array.length);
        return inversePairsCounter(array, 0, array.length-1, copy);
    }

    private int inversePairsCounter(int[] array, int start, int end, int[] copy) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int mid = (start + end) / 2;
        int left = inversePairsCounter(copy, start, mid, array); // 交换copy和array位置，复用空间
        int right = inversePairsCounter(copy, mid+1, end, array);

        int counter = 0;
        int i = mid;  // 左边数组索引
        int j = end;  // 右边数组索引
        int mergeIndex = end;      // 合并后数组索引，从尾部放入
        while (i >= start && j >= mid+1) {
            if (array[i] > array[j]) {
                counter = counter + (j - (mid+1) + 1);
                copy[mergeIndex--] = array[i--];
            } else {
                copy[mergeIndex--] = array[j--];
            }
        }

        // 复制所有数据
        while(i >= start) {
            copy[mergeIndex--] = array[i--];
        }
        while(j >= mid+1) {
            copy[mergeIndex--] = array[j--];
        }

        return left + right + counter;
    }
}
