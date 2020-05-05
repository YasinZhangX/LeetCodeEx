package medium;

/**
 * @author Yasin Zhang
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = num;
            } else {
                sum = sum + num;
                res = Math.max(res, sum);
            }

            res = Math.max(res, sum);
        }

        return res;
    }

    public int maxSubArrayDivideConquer(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return helper(nums, 0, nums.length-1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = (start + end) / 2;
        int leftSum = helper(nums, start, mid);
        int rightSum = helper(nums, mid+1, end);
        int crossSum = crossSum(nums, start, end, mid);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int crossSum(int[] nums, int start, int end, int mid) {
        int i = mid;
        int leftSum = 0;
        int left = Integer.MIN_VALUE;
        while (i >= start) {
            leftSum = leftSum + nums[i];
            left = Math.max(left, leftSum);
            i--;
        }
        int right = 0;
        int rightSum = 0;
        i = mid + 1;
        while (i <= end) {
            rightSum = rightSum + nums[i];
            right = Math.max(right, rightSum);
            i++;
        }

        return left + right;
    }
}
