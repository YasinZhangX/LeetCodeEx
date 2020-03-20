package medium;

import java.util.Random;

/**
 * @author Yasin Zhang
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while(index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }

        return nums[k-1];
    }

    private int partition(int[] nums, int start, int end) {
        int index = new Random().nextInt(end-start+1) + start;
        int tmp = nums[index];
        nums[index] = nums[start];
        nums[start] = tmp;

        int large = start;
        for (int i = start+1; i <= end; i++) {
            if (nums[i] > nums[start]) {
                large++;
                int t = nums[i];
                nums[i] = nums[large];
                nums[large] = t;
            }
        }
        tmp = nums[start];
        nums[start] = nums[large];
        nums[large] = tmp;

        return large;
    }
}
