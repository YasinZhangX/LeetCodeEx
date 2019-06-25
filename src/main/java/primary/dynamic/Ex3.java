package primary.dynamic;

public class Ex3 {
    public int maxSubArray(int[] nums) {
        return subMax(nums, 0, nums.length-1);
    }

    private int subMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int mid = (left + right) / 2;
        int maxLeftSubSum = subMax(nums, left, mid);
        int maxRigthSubSum = subMax(nums, mid+1, right);
        
        int maxLeftSum = -Integer.MAX_VALUE, LeftSum = 0;
        for (int i = mid; i >= left; i--) {
            LeftSum = LeftSum + nums[i];
            if (LeftSum > maxLeftSum) {
                 maxLeftSum = LeftSum;
            }
        }
        
        int maxRigthSum = -Integer.MAX_VALUE, RightSum = 0;
        for (int i = mid+1; i <= right; i++) {
            RightSum = RightSum + nums[i];
            if (RightSum > maxRigthSum) {
                maxRigthSum = RightSum;
            }
        }
        
        return Math.max(Math.max(maxLeftSubSum, maxRigthSubSum), (maxLeftSum + maxRigthSum));
    }
    
    public int maxSubArray_best(int[] nums) {
        int maxsum = Integer.MIN_VALUE, tempsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tempsum < 0)
                tempsum = nums[i];
            else
                tempsum += nums[i];
            if (tempsum > maxsum)
                maxsum = tempsum;
        }
        return maxsum;
    }
}
