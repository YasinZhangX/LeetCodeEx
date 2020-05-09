package medium;

import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCount = new HashMap<>();  // 存储前缀和与次数的映射

        int result = 0;
        int pre = 0;
        sumCount.put(0, 1);
        for (int num : nums) {
            pre = pre + num;
            Integer count = sumCount.getOrDefault(pre - k, 0);
            result = result + count;
            count = sumCount.getOrDefault(pre, 0);
            sumCount.put(pre, count+1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }
}
