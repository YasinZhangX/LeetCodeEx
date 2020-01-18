package medium;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * @author Yasin Zhang
 */
public class NextPermutation {
    public void solution(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i-1] > nums[i]) {
            i--;
        }

        if (i == 0) {
            reverse(nums);
            return;
        }

        Arrays.sort(nums, i, nums.length);
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > nums[i-1]) {
                swap(nums, i-1, j);
                break;
            }
        }
    }

    private void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - i - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
