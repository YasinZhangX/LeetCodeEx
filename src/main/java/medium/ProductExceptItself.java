package medium;

import java.util.Arrays;

/**
 * @author Yasin Zhang
 */
public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0) {
                res[i] = res[i] * res[i-1] * nums[i-1];
            }
        }

        int product = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i+1 < nums.length) {
                product = product * nums[i+1];
            }

            res[i] = res[i] * product;
        }

        return res;
    }
}
