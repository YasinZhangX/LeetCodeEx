package easy;

/**
 * 最大自序和
 * 有两种方法，在此给出比较复杂的分治法
 * @author Yasin Zhang
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        return DivideAndConquer(nums, 0, nums.length-1);
    }

    private int DivideAndConquer(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (start == end) {
            return nums[start];
        }

        int mid = (start + end) / 2;
        int leftMaxSum = DivideAndConquer(nums, start, mid);
        int rightMaxSum = DivideAndConquer(nums, mid+1, end);
        int crossMaxSum = crossSum(nums, start, mid, end);

        return Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);
    }

    private int crossSum(int[] nums, int start, int mid, int end) {
        if (start == end) {
            return nums[start];
        }

        int i = mid;
        int leftSum = 0;
        int maxleft = Integer.MIN_VALUE;
        while (i >= start) {
            leftSum = leftSum + nums[i];
            maxleft = Math.max(leftSum, maxleft);
            i--;
        }

        i = mid+1;
        int rightSum = 0;
        int maxright = Integer.MIN_VALUE;
        while (i <= end) {
            rightSum = rightSum + nums[i];
            maxright = Math.max(rightSum, maxright);
            i++;
        }

        return maxleft+maxright;
    }
}
