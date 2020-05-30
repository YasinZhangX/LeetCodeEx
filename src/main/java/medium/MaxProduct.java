package medium;

/**
 * 152. 乘积最大子数组
 * @author Yasin Zhang
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            int tmp = max;
            max = Math.max(num, Math.max(max * num, min * num));
            min = Math.min(num, Math.min(tmp * num, min * num));
            res = Math.max(max, res);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxProduct alg = new MaxProduct();
        int[] nums = {-4, -3, -2};
        int result = alg.maxProduct(nums);
        System.out.println(result);
    }
}
