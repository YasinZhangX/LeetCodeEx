package medium;

import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        int sum = 0;
        dict.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (dict.containsKey(sum)) {
                if (i-dict.get(sum) > 1) {
                    return true;
                }
            } else {
                dict.put(sum, i);
            }
        }

        return false;
    }
}
