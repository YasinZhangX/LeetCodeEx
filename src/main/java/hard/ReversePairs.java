package hard;

import java.util.Arrays;

/**
 * 数组中的逆序对
 * @author Yasin Zhang
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        return reversePairs(nums, copy, 0, nums.length-1);
    }

    private int reversePairs(int[] nums, int[] copy, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        int left = reversePairs(copy, nums, start, mid);
        int right = reversePairs(copy, nums, mid+1, end);

        int pairNum = 0;
        int i = mid;
        int j = end;
        int index = end;
        while (i >= start && j >= mid+1) {
            if (nums[i] > nums[j]) {
                copy[index--] = nums[i];
                pairNum += j - mid;
                i--;
            } else {
                copy[index--] = nums[j];
                j--;
            }
        }

        while (i >= start) {
            copy[index--] = nums[i--];
        }
        while (j >= mid+1) {
            copy[index--] = nums[j--];
        }

        return left + right + pairNum;
    }
}
