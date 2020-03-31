package medium;

import java.util.Random;

/**
 * @author Yasin Zhang
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        randomQuickSort(nums, 0, nums.length-1);

        return nums;
    }

    private void randomQuickSort(int[] nums, int start, int end) {
        if (nums == null || start >= end) {
            return;
        }

        int index = partition(nums, start, end);

        randomQuickSort(nums, start, index-1);
        randomQuickSort(nums, index+1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int r = new Random().nextInt(end-start+1) + start;
        int t;
        if (r != start) {
            t = nums[r];
            nums[r] = nums[start];
            nums[start] = t;
        }


        int index = start + 1;
        int small = start;
        while(index <= end) {
            if (nums[index] <= nums[start]) {
                small++;
                if (index == small) {
                    index++;
                    continue;
                }
                t = nums[index];
                nums[index] = nums[small];
                nums[small] = t;
            }

            index++;
        }

        t = nums[small];
        nums[small] = nums[start];
        nums[start] = t;

        return small;
    }
}
